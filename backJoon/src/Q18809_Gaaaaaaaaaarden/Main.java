package Q18809_Gaaaaaaaaaarden;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

// 배양 액을 넣을 수 있는 땅에 순열 진행.
// 순열마다, BFS 진행
// 시간이 동일한 초록+빨강이면 걔는 보라색으로
// 최종 갯수 업데이트
public class Main {
    static int N, M, G, R, map[][], ans;
    static int[][][] tmp_map;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};
    static List<int[]> pos, tmp;
    static List<Integer> gList, rList;
    static boolean visited[];
    static Queue<int[]> q = new LinkedList<>();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        G = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        pos = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 2) {
                    pos.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[pos.size()];
        tmp = new ArrayList<>();
        gList = new ArrayList<>();
        rList = new ArrayList<>();
    }

    private static int bfs() {
        tmp_map = new int[N][M][2];

        for (int idx : gList) {
            int r = pos.get(idx)[0];
            int c = pos.get(idx)[1];
            tmp_map[r][c][0] = 1;
            q.add(new int[]{r, c});
        }

        for (int idx : rList) {
            int r = pos.get(idx)[0];
            int c = pos.get(idx)[1];
            tmp_map[r][c][0] = 2;
            q.add(new int[]{r, c});
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int c = tmp_map[curr[0]][curr[1]][0];
            int t = tmp_map[curr[0]][curr[1]][1];

            if (c == 3) continue;
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0) continue;

                if (tmp_map[nr][nc][0] == 0) {
                    tmp_map[nr][nc][0] = c;
                    tmp_map[nr][nc][1] = t + 1;
                    q.add(new int[]{nr, nc});
                } else if (tmp_map[nr][nc][0] != 3) {
                    if (tmp_map[nr][nc][1] == t + 1 && tmp_map[nr][nc][0] != c) {
                        tmp_map[nr][nc][0] = 3;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static void solve(int idx, int cnt, int g, int r) {
        if (cnt > pos.size()) return;
        if (g > G) return;
        if (r > R) return;

        if (g == G && r == R) {
            ans = Math.max(ans, bfs());
            return;
        }

        for (int i = idx; i < pos.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                gList.add(i);
                solve(i + 1, cnt + 1, g + 1, r);
                gList.remove(gList.size() - 1);
                rList.add(i);
                solve(i + 1, cnt + 1, g, r + 1);
                rList.remove(rList.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve(0, 0, 0, 0);
        output();
    }
}
