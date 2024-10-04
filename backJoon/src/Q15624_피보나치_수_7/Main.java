package Q15624_피보나치_수_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        if (N == 0) {
            System.out.println(0);
            return;
        }

        dp[1] = 1;

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % ((int) 1e9 + 7);
        }

        System.out.println(dp[N]);
    }
}
