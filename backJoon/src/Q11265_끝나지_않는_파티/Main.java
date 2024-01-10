package Q11265_끝나지_않는_파티;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N, M, a[][];
	private String enjoy = "Enjoy other party";
	private String stay = "Stay here";
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());


			sb.append(a[n1][n2] <= cost ? enjoy : stay).append("\n");
		}
		System.out.print(sb.toString());
	}

	private void solve() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (a[i][j] > a[i][k] + a[k][j]) {
						a[i][j] = a[i][k] + a[k][j];
					}
				}
			}
		}
	}

	private void input() throws Exception {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		a = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}
