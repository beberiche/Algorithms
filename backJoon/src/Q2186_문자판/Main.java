package Q2186_문자판;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N, M, K, dp[][][], ans;
    int dr[] = {-1, 0, 1, 0};
    int dc[] = {0, -1, 0, 1};
    String map[], cmp;
    boolean visited[][];

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.input();
        m.solve();
        m.output();
    }

    private void output() {
        System.out.println(ans);
    }

    private int dfs(int idx, int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= M || cmp.charAt(idx) != map[r].charAt(c)) {
            return 0;
        }

        if (idx >= cmp.length() - 1) {
            return dp[r][c][idx] = 1;
        }

        if (dp[r][c][idx] != -1) return dp[r][c][idx];

        dp[r][c][idx] = 0;
        for (int d = 0; d < 4; d++) {
            for (int x = 1; x <= K; x++) {
                int nr = r + dr[d] * x;
                int nc = c + dc[d] * x;

                dp[r][c][idx] += dfs(idx + 1, nr, nc);
            }
        }
        return dp[r][c][idx];
    }

    private void solve() {
        int c = cmp.charAt(0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char ch = map[i].charAt(j);
                if (ch == c) {
                    ans += dfs(0, i, j);
                }
            }
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        map = new String[N];


        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        cmp = br.readLine();
        dp = new int[N][M][cmp.length()];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
    }
}
