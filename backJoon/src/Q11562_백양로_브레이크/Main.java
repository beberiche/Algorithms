package Q11562_백양로_브레이크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int N, M, a[][], INF = (int) 1e9;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private StringBuilder sb;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() throws Exception {

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (a[i][j] > a[i][k] + a[k][j]) {
						a[i][j] = a[i][k] + a[k][j];
					}
				}
			}
		}

		int K = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			sb.append(a[n1][n2]).append("\n");
		}
	}

	private void input() throws Exception {
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(a[i], INF);
			a[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			a[u][v] = 0;
			a[v][u] = (b + 1) % 2;
		}
	}
}
