package Q17485_진우의_달_여행_Large;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int N, M, INF = (int) 1e9;
	private int a[][], dp[][][];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
	}

	private void solve() {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int nc_left = j - 1;
				int nc_right = j + 1;

				if (nc_left >= 0)
					dp[i][j][0] = Math.min(dp[i - 1][nc_left][1], dp[i - 1][nc_left][2]) + a[i][j];
				if (nc_right < M)
					dp[i][j][1] = Math.min(dp[i - 1][nc_right][0], dp[i - 1][nc_right][2]) + a[i][j];
				dp[i][j][2] = Math.min(dp[i - 1][j][0], dp[i - 1][j][1]) + a[i][j];
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				ans = Math.min(ans, dp[N - 1][i][j]);
			}
		}
		System.out.println(ans);
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[N][M];
		dp = new int[N][M][3];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				if (i == 0) {
					dp[i][j][0] = a[i][j];
					dp[i][j][1] = a[i][j];
					dp[i][j][2] = a[i][j];
				} else {
					Arrays.fill(dp[i][j], INF);
				}
			}
		}
	}
}
