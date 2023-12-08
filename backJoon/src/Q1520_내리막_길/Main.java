package Q1520_내리막_길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int N, M, map[][], dp[][];
    int dr[] = {-1, 0, 0, 1};
    int dc[] = {0, -1, 1, 0};
    boolean visited[][];

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
    }

    private int dfs(int r, int c) {
        if (r == N - 1 && c == M - 1) {
            dp[r][c] = 1;
            return dp[r][c];
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] >= map[r][c])
                continue;

            dp[r][c] += dfs(nr, nc);
        }
        visited[r][c] = false;

        return dp[r][c];
    }

    private void solve() {
        visited = new boolean[N][M];
        dfs(0, 0);
    }

    private void output() {
        System.out.println(dp[0][0]);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }
}
