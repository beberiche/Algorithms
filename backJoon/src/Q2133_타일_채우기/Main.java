package Q2133_타일_채우기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[N + 1];
        dp[0] = 1;
        for (int i = 2; i <= N; i += 2) {
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j];
            }
            dp[i] *= 2;
            dp[i] += (dp[i - 2] * dp[2]);
        }
        System.out.println(dp[N]);
    }
}
