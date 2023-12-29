package Q16933_벽_부수고_이동하기_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int N, M, K, a[][], ans = -1;

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(ans);
    }

    private void solve() {
        Queue<int[]> q = new LinkedList<>();
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, -1, 0, 1};
        boolean visited[][][] = new boolean[N][M][K + 1];
        q.add(new int[]{0, 0, 0, 0});

        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == N - 1 && curr[1] == M - 1) {
                ans = curr[2] + 1;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (a[nr][nc] == 1 && curr[3] < K) {
                    if (curr[2] % 2 == 0 && !visited[nr][nc][curr[3] + 1]) {
                        visited[nr][nc][curr[3] + 1] = true;
                        q.add(new int[]{nr, nc, curr[2] + 1, curr[3] + 1});
                    } else if (curr[2] % 2 == 1) {
                        q.add(new int[]{curr[0], curr[1], curr[2] + 1, curr[3]});
                    }
                } else if (a[nr][nc] == 0 && !visited[nr][nc][curr[3]]) {
                    visited[nr][nc][curr[3]] = true;
                    q.add(new int[]{nr, nc, curr[2] + 1, curr[3]});
                }
            }
        }
    }

    private void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        a = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                a[i][j] = str.charAt(j) - '0';
            }
        }
    }
}