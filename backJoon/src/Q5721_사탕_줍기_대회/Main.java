package Q5721_사탕_줍기_대회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer stk;
	private static int N, M, max;

	private int a[][], dp[][], dp2[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		while (true) {
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			if (N == 0 && M == 0) return;

			m.input();
			m.solve();
			m.output();
		}
	}

	private void output() {
		System.out.println(dp2[N + 1]);
	}

	private void solve() {
		dp = new int[N + 2][M + 2];

		for (int i = 2; i < dp.length; i++) {
			for (int j = 2; j < dp[0].length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i][j - 2] + a[i][j]);
			}
		}

		dp2 = new int[N + 2];
		for (int i = 2; i < dp.length; i++) {
			dp2[i] = Math.max(dp[i][M + 1] + dp2[i - 2], dp2[i - 1]);
		}

	}

	private void input() throws Exception {
		a = new int[N + 2][M + 2];
		for (int i = 2; i < a.length; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 2; j < a[0].length; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}
