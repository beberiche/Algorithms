package Q1757_달려달려;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());


        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            dp[i][0] = dp[i - 1][0];

            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j - 1] + num;
            }

            for (int j = 1; j <= M; j++) {
                if (i - j < 0) break;
                dp[i][0] = Math.max(dp[i][0], dp[i - j][j]);
            }
        }
        System.out.println(dp[N][0]);
    }
}
