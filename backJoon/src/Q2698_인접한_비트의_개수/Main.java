package Q2698_인접한_비트의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][][] dp = new int[101][101][2];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;
        for (int k = 0; k <= 100; k++) {
            for (int n = 2; n <= 100; n++) {
                dp[n][k][0] = dp[n - 1][k][0] + dp[n - 1][k][1];
                dp[n][k][1] = dp[n - 1][k][0];
                if (k > 0) dp[n][k][1] += dp[n - 1][k - 1][1];
            }
        }

        while (--T >= 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());
            System.out.println(dp[N][K][0] + dp[N][K][1]);
        }
    }
}
