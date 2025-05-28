package Q4150_피보나치_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    private static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new BigInteger[N];
        System.out.println(fibonacci(N));
    }

    public static BigInteger fibonacci(int n) {
        if (n == 1 || n == 2) return BigInteger.ONE;
        if (n == 0) return BigInteger.ZERO;

        if (dp[n - 1] != null) {
            return dp[n - 1];
        }

        dp[n - 1] = fibonacci(n - 1);

        if (dp[n - 2] != null) {
            return dp[n - 1].add(dp[n - 2]);
        }

        dp[n - 2] = fibonacci(n - 2);
        return dp[n - 1].add(dp[n - 2]);
    }
}
