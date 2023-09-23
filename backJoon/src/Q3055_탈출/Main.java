package Q3055_탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토와 유사한 문제
// 물이 먼저 이동, 고슴도치 이동.
// S -> X,* 로는 이동 못함.
// * -> D,X 로는 이동 못함.
public class Main {
    static int R, C, start[];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static String ans = "KAKTUS";
    static boolean[][] visited1, visited2;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        R = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());

        map = new char[R][C];
        visited1 = new boolean[R][C];
        visited2 = new boolean[R][C];
        String str;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    start = new int[]{i, j};
                    visited1[i][j] = true;
                } else if (map[i][j] == '*') {
                    visited2[i][j] = true;
                    q.add(new int[]{0, i, j, 0});
                }
            }
        }
    }

    private static void solve() {
        q.add(new int[]{1, start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == 1 && map[curr[1]][curr[2]] == 'D') {
                ans = String.valueOf(curr[3]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[1] + dr[d];
                int nc = curr[2] + dc[d];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == 'X' || visited2[nr][nc])
                    continue;

                if (curr[0] == 1 && !visited1[nr][nc] && !visited2[nr][nc]) {
                    visited1[nr][nc] = true;
                    q.add(new int[]{1, nr, nc, curr[3] + 1});
                } else if (curr[0] == 0 && map[nr][nc] != 'D') {
                    visited2[nr][nc] = true;
                    q.add(new int[]{0, nr, nc, 0});
                }
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
