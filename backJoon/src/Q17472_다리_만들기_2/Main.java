package Q17472_다리_만들기_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, map[][], dist[][], visited[][], dr[] = {-1, 0, 1, 0}, dc[] = {0, -1, 0, 1}, ans, cnt;
    static List<List<int[]>> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private static void mapInit(int idx, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        map[i][j] = idx;

        list.add(new ArrayList<>());
        list.get(list.size() - 1).add(new int[]{i, j});
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 1) continue;

                map[nr][nc] = idx;
                list.get(list.size() - 1).add(new int[]{nr, nc});
                q.add(new int[]{nr, nc});
            }
        }
    }

    private static void goBridge(int idx) {
        visited = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int[] pos : list.get(idx)) {
            q.add(new int[]{pos[0], pos[1], -1});
            visited[pos[0]][pos[1]] = 100 + idx;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (map[curr[0]][curr[1]] != 0 && map[curr[0]][curr[1]] != 100 + idx) {
                int n1 = idx;
                int n2 = map[curr[0]][curr[1]] - 100;
                if (visited[curr[0]][curr[1]] - 100 - idx - 1 <= 1) continue;

                dist[n1][n2] = Math.min(dist[n1][n2], visited[curr[0]][curr[1]] - 100 - idx - 1);
                dist[n2][n1] = Math.min(dist[n2][n1], visited[curr[0]][curr[1]] - 100 - idx - 1);
                continue;
            }
            int nr, nc;
            if (curr[2] == -1) {
                for (int d = 0; d < 4; d++) {
                    nr = curr[0] + dr[d];
                    nc = curr[1] + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] != 0) continue;
                    visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
                    q.add(new int[]{nr, nc, d});
                }
            } else {
                nr = curr[0] + dr[curr[2]];
                nc = curr[1] + dc[curr[2]];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] != 0) continue;
                visited[nr][nc] = visited[curr[0]][curr[1]] + 1;
                q.add(new int[]{nr, nc, curr[2]});
            }
        }
    }

    private static void prim() {
        boolean[] visited = new boolean[list.size()];
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
        pq.add(new int[]{0, 0});

        cnt = 0;
        ans = 0;

        while (!pq.isEmpty() && cnt < list.size()) {
            int[] curr = pq.poll();

            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            ans += curr[1];
            cnt++;
            for (int d = 0; d < list.size(); d++) {
                if (visited[d] || dist[curr[0]][d] == Integer.MAX_VALUE) continue;
                pq.add(new int[]{d, dist[curr[0]][d]});
            }
        }
    }

    private static void solve() {
        list = new ArrayList<>();
        // 섬 구성
        int idx = 100;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    mapInit(idx, i, j);
                    idx++;
                }
            }
        }

        // 인접 행렬 만들기
        dist = new int[list.size()][list.size()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            goBridge(i);
        }

        // 최소 스패닝 트리 길이 구하기
        prim();
    }

    private static void output() {
        System.out.println(cnt == list.size() ? ans : -1);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
