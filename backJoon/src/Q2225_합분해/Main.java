package Q2225_합분해;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, dp[][];
    static int MOD = 1000000000;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }
    }

    private static void solve() {
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
    }

    private static void output() {
        System.out.println(dp[K][N]);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
