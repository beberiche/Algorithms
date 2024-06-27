package Q17208_카우버거_알바생;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K, order[][], dp[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		order = new int[N + 1][];

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			order[i] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
		}


		dp = new int[N + 1][M + 1][K + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int ans = go(0, M, K);
		System.out.println(ans);
	}

	private static int go(int i, int c, int p) {
		if (i == N) return 0;

		if (dp[i][c][p] >= 0) {
			return dp[i][c][p];
		}

		if (order[i + 1][0] <= c && order[i + 1][1] <= p) {
			// 현재 경우를 반영
			dp[i][c][p] = go(i + 1, c - order[i + 1][0], p - order[i + 1][1]) + 1;
		}

		// 현재 경우를 반영하지 않음
		dp[i][c][p] = Math.max(dp[i][c][p], go(i + 1, c, p));

		return dp[i][c][p];
	}
}
