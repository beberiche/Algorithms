package Q23559_밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private int N, cost, ans;
	private PriorityQueue<Integer> pq;

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
		while (!pq.isEmpty() && pq.peek() > 0 && cost >= 4000) {
			ans += pq.poll();
			cost -= 4000;
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		cost = Integer.parseInt(stk.nextToken());

		ans = 0;
		cost -= 1000 * N;
		pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			pq.add(n1 - n2);
			ans += n2;
		}
	}
}
