package Q16946_벽_부수고_이동하기_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, arr[][], visited[][], ret[][];
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, -1, 0, 1};
    static Queue<int[]> q = new LinkedList<>();
    static List<int[]> list;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
    }

    private static void bfs(int r, int c) {
        list = new ArrayList<>();
        q.add(new int[]{r, c});
        list.add(new int[]{r, c});
        visited[r][c] = 1;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (visited[nr][nc] >= 1 || arr[nr][nc] == 1) continue;

                visited[nr][nc] = 1;
                q.add(new int[]{nr, nc});
                list.add(new int[]{nr, nc});
                cnt++;
            }
        }

        Set<String> s_visited = new HashSet<>();
        for (int[] pos : list) {
            for (int d = 0; d < 4; d++) {
                int nr = pos[0] + dr[d];
                int nc = pos[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                String tmp = nr + ":" + nc;
                if (arr[nr][nc] == 0 || s_visited.contains(tmp)) continue;

                s_visited.add(tmp);
                ret[nr][nc] += cnt % 10;
            }
        }
    }

    private static void solve() {
        visited = new int[N][M];
        ret = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && arr[i][j] == 0) bfs(i, j);
            }
        }
    }

    private static void output() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) ret[i][j]++;
                sb.append(ret[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
