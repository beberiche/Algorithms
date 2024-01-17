package Q18427_함께_블록_쌓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int H = Integer.parseInt(stk.nextToken());
		int MOD = 10007;

		int[][] dp = new int[N + 1][H + 1];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= H; j++) {
				dp[i][j] = dp[i - 1][j];
			}
			while (stk.hasMoreTokens()) {
				int val = Integer.parseInt(stk.nextToken());
				if (val > H) continue;
				dp[i][val]++;
				for (int k = val + 1; k <= H; k++) {
					dp[i][k] += dp[i - 1][k - val];
					dp[i][k] %= MOD;
				}
			}
		}
		System.out.println(dp[N][H]);
	}
}
