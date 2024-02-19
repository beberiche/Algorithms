package Q17182_우주_탐사선;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N, K, a[][], ans = Integer.MAX_VALUE, goal;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(ans);
	}

	private void solve() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (a[i][j] > a[i][k] + a[k][j]) {
						a[i][j] = a[i][k] + a[k][j];
					}
				}
			}
		}


		goal = (1 << N) - 1;
		dfs(K, 0, 1 << K);
	}

	private void dfs(int node, int dist, int visited) {
		if (visited == goal) {
			ans = Math.min(ans, dist);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (node == i || (visited & (1 << i)) != 0) continue;
			dfs(i, dist + a[node][i], visited | (1 << i));
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		a = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}
