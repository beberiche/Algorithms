package Q2073_수도배관공사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(stk.nextToken());
		int P = Integer.parseInt(stk.nextToken());

		int dp[] = new int[D + 1];
		dp[0] = 1 << 24;
		for (int i = 1; i <= P; i++) {
			stk = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			for (int j = D; j >= l; j--) {
				dp[j] = Math.max(dp[j], Math.min(dp[j - l], c));
			}
		}
		System.out.println(dp[D]);
	}
}