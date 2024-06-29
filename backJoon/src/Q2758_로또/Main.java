package Q2758_로또;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		long dp[][] = new long[11][2001];
		Arrays.fill(dp[0], 1);

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
			}
		}

		StringBuilder sb = new StringBuilder();
		while (--T >= 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			sb.append(dp[N][M]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
