package Q14567_선수과목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M, d[], dp[];
	private List<Integer> list[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(dp[i]).append(" ");
		}
		System.out.print(sb.toString());
	}

	private void solve() {
		go();
	}

	private void go() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (d[i] == 0) {
				q.add(i);
				dp[i] = 1;
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : list[curr]) {
				if (--d[next] == 0) {
					dp[next] = dp[curr] + 1;
					q.add(next);
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		d = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			list[n1].add(n2);
			d[n2]++;
		}

		dp = new int[N + 1];
	}
}
