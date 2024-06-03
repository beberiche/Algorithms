package Q14925_목장_건설하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N, M, a[][], ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private void solve() {
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				if (a[i][j] == -1) continue;

				int u = a[i - 1][j];
				int l = a[i][j - 1];
				int ul = a[i - 1][j - 1];

				if (u == -1 || l == -1 || ul == -1) a[i][j] = 1;
				else a[i][j] = Math.min(u, Math.min(l, ul)) + 1;

				ans = Math.max(ans, a[i][j]);
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		a = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				if (a[i][j] != 0) a[i][j] = -1;

				if (a[i][j] == 0 && (i == 0 || j == 0)) {
					a[i][j] = 1;
					ans = 1;
				}
			}
		}
	}
}
