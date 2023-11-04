package Q11057_오르막_수;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum[] = new int[N + 1];
        int dp[][] = new int[N + 1][10];
        int DIV = 10007;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        sum[1] = 9;

        int ans = sum[1];
        for (int i = 2; i <= N; i++) {
            dp[i][1] = sum[i - 1];
            sum[i] = sum[i - 1] % DIV;
            for (int j = 2; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % DIV;
                }
                sum[i] = (sum[i] + dp[i][j]) % DIV;
            }
            ans = (ans + sum[i]) % DIV;
        }

        System.out.println((ans + 1) % DIV);
    }
}
