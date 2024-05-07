package Q17616_등수_찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private List<Integer> list[][];
	private boolean visited[][];
	private int N, X, U, V;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(U + " " + V);
	}

	private void solve() {
		U = 1;
		V = N;

		U += dfs(X, 0);
		V -= dfs(X, 1);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		X = Integer.parseInt(stk.nextToken());

		int d = 2;

		list = new ArrayList[d][N + 1];
		visited = new boolean[d][N + 1];
		for (int i = 0; i < d; i++) {
			for (int j = 1; j <= N; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			list[0][n2].add(n1);
			list[1][n1].add(n2);
		}
	}

	private int dfs(int idx, int d) {
		visited[d][idx] = true;
		int ret = 1;
		for (int next : list[d][idx]) {
			if (!visited[d][next]) ret += dfs(next, d);
		}
		return ret;
	}
}
