package Q14728_벼락치기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int T = Integer.parseInt(stk.nextToken());

        int[][] dp = new int[N + 1][10004];

        for (int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(stk.nextToken());
            int val = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < t; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for (int j = t; j <= 10000; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - t] + val, dp[i - 1][j]);
            }
        }

        System.out.println(dp[N][T]);
    }
}
