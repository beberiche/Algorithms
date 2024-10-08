package Q17175_피보나치는_지겨웡;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int dp[], MOD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        MOD = (int) 1e9 + 7;
        System.out.println((go(N) + 1) % MOD);

    }

    private static int go(int n) {
        if (n < 2) return 0;

        if (dp[n] > 0) return dp[n];
        int ret1 = (go(n - 2) + 1) % MOD;
        int ret2 = (go(n - 1) + 1) % MOD;

        return dp[n] = (ret1 + ret2) % MOD;
    }
}
