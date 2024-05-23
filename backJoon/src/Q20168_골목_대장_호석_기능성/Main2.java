package Q20168_골목_대장_호석_기능성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	private int N, M, A, B, C, ans, arr[][], INF = (int) 1e9;
	private boolean[] visited;

	public static void main(String[] args) throws Exception {
		Main2 m = new Main2();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans == INF ? -1 : ans);
	}

	private void solve() {
		ans = INF;
		go(A, 0, 0);
	}

	private void go(int node, int cost, int max) {
		if (cost > C) {
			return;
		}

		if (node == B) {
			ans = Math.min(ans, max);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (arr[node][i] == 0 || visited[i]) continue;
			visited[i] = true;
			go(i, cost + arr[node][i], Math.max(max, arr[node][i]));
			visited[i] = false;
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());

		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			arr[a][b] = c;
			arr[b][a] = c;
		}

		visited = new boolean[N + 1];
	}
}
