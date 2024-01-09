package Q1577_도로의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N, M, K;
	private long dp[][];

	private boolean a[][][];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(dp[N][M]);
	}

	private void solve() {
		dp = new long[N + 1][M + 1];
		dp[0][0] = 1;
		for (int j = 1; j <= M; j++) {
			dp[0][j] = a[0][j][2] && a[0][j - 1][3] ? 0 : dp[0][j - 1];
		}

		for (int i = 1; i <= N; i++) {
			dp[i][0] = a[i][0][0] && a[i - 1][0][1] ? 0 : dp[i - 1][0];
		}

		// 상하좌우
		long ret1, ret2;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				ret1 = a[i][j][0] && a[i - 1][j][1] ? 0 : dp[i - 1][j];
				ret2 = a[i][j][2] && a[i][j - 1][3] ? 0 : dp[i][j - 1];
				dp[i][j] = ret1 + ret2;
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new boolean[N + 1][M + 1][4];
		K = Integer.parseInt(br.readLine());
		for (int k = 1; k <= K; k++) {
			stk = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(stk.nextToken());
			int c1 = Integer.parseInt(stk.nextToken());
			int r2 = Integer.parseInt(stk.nextToken());
			int c2 = Integer.parseInt(stk.nextToken());

			// 상하좌우
			if (r1 < r2) {
				a[r1][c1][1] = true;
				a[r2][c2][0] = true;
			} else if (r2 < r1) {
				a[r2][c2][1] = true;
				a[r1][c1][0] = true;
			} else if (c1 < c2) {
				a[r1][c1][3] = true;
				a[r2][c2][2] = true;
			} else if (c2 < c1) {
				a[r2][c2][3] = true;
				a[r1][c1][2] = true;
			}
		}
	}
}
