package Q10844_쉬운_계단_수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int INF = (int) 1e9;

        int dp[][] = new int[N + 1][10];

        for (int i = 1; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][1];
                else if (j == 9) dp[i][j] = dp[i - 1][8];
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];

                dp[i][j] %= INF;
            }
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N][i];
            ans %= INF;
        }
        System.out.println(ans);
    }
}
