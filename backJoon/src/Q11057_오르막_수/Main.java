package Q11057_오르막_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum[] = new int[N + 1];
        int dp[][] = new int[N + 1][10];
        int DIV = 10007;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        sum[1] = 9;

        int ans = sum[1];
        for (int i = 2; i <= N; i++) {
            dp[i][1] = sum[i - 1];
            sum[i] = (sum[i] + dp[i][1]) % DIV;
            for (int j = 2; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + DIV - dp[i - 1][j - 1]) % DIV;
                sum[i] = (sum[i] + dp[i][j]) % DIV;
            }
            ans = (ans + sum[i]) % DIV;
        }

        System.out.println((ans + 1) % DIV);
    }
}
