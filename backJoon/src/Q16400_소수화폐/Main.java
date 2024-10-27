package Q16400_소수화폐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] prime = new int[N + 1]; // 1 => 소수 아님.
        int[] dp = new int[N + 1];
        prime[0] = 1;
        prime[1] = 1;
        List<Integer> p = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = 1;
                }
                p.add(i);
            }
        }
        final int MOD = 123_456_789;
        dp[0] = 1;
        for (int i = 0; i < p.size(); i++) {
            for (int j = p.get(i); j <= N; j++) {
                dp[j] = (dp[j] + dp[j - p.get(i)]) % MOD;
            }
        }
        System.out.println(dp[N]);
    }
}
