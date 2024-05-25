package Q25195_Yes_or_yes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M;
	private List<Integer> list[];
	private boolean fan[], ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans ? "yes" : "Yes");
	}

	private void solve() {
		if (fan[1]) {
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		while (!q.isEmpty()) {
			int curr = q.poll();

			if (list[curr].size() == 0) {
				ans = true;
				break;
			}

			for (int next : list[curr]) {
				if (!fan[next]) q.add(next);
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		list = new ArrayList[N + 1];
		fan = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			list[n1].add(n2);
		}

		int f = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		while (--f >= 0) {
			fan[Integer.parseInt(stk.nextToken())] = true;
		}
	}
}
