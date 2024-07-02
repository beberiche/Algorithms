package Q1947_선물_전달;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N <= 2) {
			System.out.println(N == 1 ? 0 : 1);
			return;
		}

		long[] dp = new long[N + 1];
		dp[2] = 1;

		long MOD = (long) 1e9;
		for (int i = 3; i <= N; i++) {
			dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]);
			dp[i] %= MOD;
		}

		System.out.println(dp[N]);
	}
}
