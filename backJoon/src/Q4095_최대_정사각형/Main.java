package Q4095_최대_정사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());

			if (N == 0 || M == 0) break;

			int[][] dp = new int[N+1][M+1];

			int max = 0;
			for (int i = 1; i <= N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					dp[i][j] = Integer.parseInt(stk.nextToken());
					if (dp[i][j] == 0) continue;

					int pr = i - 1;
					int pc = j - 1;

					dp[i][j] = Math.min(dp[pr][j], Math.min(dp[i][pc], dp[pr][pc])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb.toString());
	}
}
