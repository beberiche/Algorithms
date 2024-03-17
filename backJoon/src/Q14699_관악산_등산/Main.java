package Q14699_관악산_등산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
	private int N, M;
	private int[] a, dp;
	private List<Integer>[] list;
	private StringBuilder sb = new StringBuilder();
	private PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() {
		Supplier<Integer> s = () -> 42;
		System.out.println(s.get());
		Runnable r = () -> System.out.println("go");
		r.run();
		List<Integer> l = new ArrayList<>();
		Function<Integer, Integer> n = (num) -> num * num;
		n.apply(3);

		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			sb.append(dfs(i)).append("\n");
		}
	}

	private int dfs(int node) {
		if (dp[node] != 0) {
			return dp[node];
		}

		int ret = 0;
		for (int next : list[node]) {
			if (a[node] >= a[next]) {
				continue;
			}
			ret = Math.max(ret, dfs(next));
		}

		return dp[node] = ret + 1;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		a = new int[N + 1];
		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			list[n1].add(n2);
			list[n2].add(n1);
		}
	}
}
