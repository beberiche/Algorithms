package Q1689_겹치는_선분;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private PriorityQueue<int[]> pq1 = new PriorityQueue<>((n1, n2) -> {
		if (n1[0] == n2[0]) return n1[1] - n2[1];
		return n1[0] - n2[0];
	});
	private int N, ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private void solve() {
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		pq2.add(pq1.poll()[1]);
		ans = 1;
		while (!pq1.isEmpty()) {
			int[] curr = pq1.poll();

			if (pq2.peek() <= curr[0]) pq2.poll();
			pq2.add(curr[1]);

			ans = Math.max(ans, pq2.size());
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			pq1.add(new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});
		}
	}
}
