package Q19154_AI의_반란_최후의_전쟁;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static final int MAX_N = 50;
	static final int INF = 50 * (int) 1e6 * 2 + 4;
	static int N, arr[][] = new int[MAX_N][3], dp[][][] = new int[MAX_N][MAX_N][MAX_N];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			// init
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(stk.nextToken());
				arr[i][1] = Integer.parseInt(stk.nextToken());
				arr[i][2] = Integer.parseInt(stk.nextToken());
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Arrays.fill(dp[i][j], 0);
				}
			}

			// solve
			int ans;
			if (N < 3) ans = -1;
			else ans = solve(0, 0, 0, 0);

			// output
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int solve(int idx, int a, int b, int c) {
		if (idx >= N) {
			if (a != 0 && b != 0 && c != 0) return 0;
			return INF;
		}

		if (dp[a][b][c] != 0) return dp[a][b][c];

		dp[a][b][c] = INF;
		dp[a][b][c] = Math.min(dp[a][b][c], solve(idx + 1, a + 1, b, c) + arr[idx][1] + arr[idx][2]);
		dp[a][b][c] = Math.min(dp[a][b][c], solve(idx + 1, a, b + 1, c) + arr[idx][0] + arr[idx][2]);
		dp[a][b][c] = Math.min(dp[a][b][c], solve(idx + 1, a, b, c + 1) + arr[idx][0] + arr[idx][1]);
		return dp[a][b][c];
	}
}
