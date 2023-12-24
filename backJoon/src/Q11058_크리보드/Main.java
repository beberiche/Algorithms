package Q11058_크리보드;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = new Scanner(System.in).nextInt();

        if (N <= 6) {
            System.out.println(N);
            return;
        }


        long dp[] = new long[N + 1];

        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= N; i++) {
            for (int j = 3; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }

        System.out.println(dp[N]);
    }
}
