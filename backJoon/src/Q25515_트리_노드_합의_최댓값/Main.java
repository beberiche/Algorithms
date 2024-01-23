package Q25515_트리_노드_합의_최댓값;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, a[], INF = -(int) 1e5 - 4;
	private long dp[];
	private List<Integer> t[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(dp[0]);
	}

	private void solve() {
		go(0);
	}

	private void go(int node) {
		dp[node] = a[node];

		for (int next : t[node]) {
			go(next);
			dp[node] = Math.max(dp[node], dp[node] + dp[next]);
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		t = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			t[i] = new ArrayList();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			t[n1].add(n2);
		}

		a = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		dp = new long[N];
		Arrays.fill(dp, INF);
	}
}
