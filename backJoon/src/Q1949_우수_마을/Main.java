package Q1949_우수_마을;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, a[], dp[][];
	private List<Integer> list[];
	private boolean[] visited;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve(1);
		m.output();
	}

	private void output() {
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	private void solve(int node) {
		visited[node] = true;

		dp[node][0] = 0;
		dp[node][1] = a[node];

		for (int next : list[node]) {
			if (visited[next]) continue;
			solve(next);
			dp[node][0] += Math.max(dp[next][0], dp[next][1]);
			dp[node][1] += dp[next][0];
		}
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		a = new int[N + 1];
		list = new ArrayList[N + 1];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}

		dp = new int[N + 1][2];
		visited = new boolean[N + 1];
	}
}
