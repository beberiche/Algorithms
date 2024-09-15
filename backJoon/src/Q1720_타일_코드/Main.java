package Q1720_타일_코드;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * 2;
        }

        int ret = dp[N];
        if (N % 2 == 1) {
            ret += dp[(N - 1) / 2];
        } else {
            ret += dp[N / 2] + dp[N / 2 - 1] * 2;
        }
        System.out.println(ret/2);
    }
}
