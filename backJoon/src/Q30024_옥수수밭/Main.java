package Q30024_옥수수밭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][], K, dr[] = {-1, 0, 1, 0}, dc[] = {0, -1, 0, 1};
    static boolean visited[][];
    static PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n2[2] - n1[2]);
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        K = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1 || j == 1 || i == N || j == M) {
                    pq.add(new int[]{i, j, arr[i][j]});
                    visited[i][j] = true;
                }
            }
        }
    }

    private static void solve() {
        while (K-- != 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append(curr[0]).append(" ").append(curr[1]).append("\n");
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 1 || nc < 1 || nr > N || nc > M || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                pq.add(new int[]{nr, nc, arr[nr][nc]});
            }
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
