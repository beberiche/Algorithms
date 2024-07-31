package Q1699_제곱수의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = (int) 1e6;
            for (int j = (int) Math.sqrt(i); j >= 1; j--) {
                if (j * j == i) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - j * j] + dp[j * j]);
            }
        }
        System.out.println(dp[N]);
    }
}
