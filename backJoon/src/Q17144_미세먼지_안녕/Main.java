package Q17144_미세먼지_안녕;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int map[][], u_map[][];
    static List<int[]> u_pos,d_pos;
    static int[][] uw = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static int[][] dw = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        T = Integer.parseInt(stk.nextToken());
        map = new int[R][C];
        u_map = new int[R][C];

        boolean check = false;
        for (int i = 0; i < R; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == -1) {
                    if (!check) {
                        u_pos = find_pos(new int[]{i, j}, uw);
                        check = true;
                    } else d_pos = find_pos(new int[]{i, j}, dw);
                }
            }
        }
    }

    private static List<int[]> find_pos(int[] c, int[][] dd) {
        int cnt = 0;
        int[] curr = new int[]{c[0], c[1]};
        List<int[]> list = new ArrayList<>();
        while (true) {
            int nr = curr[0] + dd[cnt][0];
            int nc = curr[1] + dd[cnt][1];
            if (nr == c[0] && nc == c[1]) break;
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                cnt++;
                continue;
            }
            curr = new int[]{nr, nc};
            list.add(new int[]{nr, nc});
        }
        return list;
    }

    private static void go() {
        // 미세먼지 확산
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0 && map[r][c] / 5 > 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int dr = r + uw[d][0];
                        int dc = c + uw[d][1];
                        if (dr < 0 || dc < 0 || dr >= R || dc >= C) continue;
                        if (map[dr][dc] == -1) continue;
                        u_map[dr][dc] += (map[r][c] / 5);
                        cnt++;
                    }
                    u_map[r][c] -= (cnt * (map[r][c] / 5));
                }
            }
        }

        // 변경사항 반영
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (u_map[r][c] != 0) {
                    map[r][c] += u_map[r][c];
                    u_map[r][c] = 0;
                }
            }
        }
    }

    private static void move(List<int[]> pos) {
        for (int i = pos.size()-1; i > 0; i--) {
            map[pos.get(i)[0]][pos.get(i)[1]] = map[pos.get(i - 1)[0]][pos.get(i - 1)[1]];
        }
        map[pos.get(0)[0]][pos.get(0)[1]] = 0;
    }


    private static void solve() {
        while (--T >= 0) {
            // 미세먼지 확산
            go();
            // 공기청정기 이동
            move(u_pos);
            move(d_pos);
        }

    }

    private static void output() {
        int ans = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]>0) ans+=map[i][j];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
