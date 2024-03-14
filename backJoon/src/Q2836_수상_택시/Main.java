package Q2836_수상_택시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private int N, M;
	private PriorityQueue<int[]> pq;
	private long sum;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(sum);
	}

	private void solve() {
		int st = 0;
		int ed = 0;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (ed < curr[0]) {
				sum += (ed - st);
				st = curr[0];
			}

			if (ed < curr[1]) {
				ed = curr[1];
			}
		}

		sum += (ed - st);
		sum *= 2;
		sum += M;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		pq = new PriorityQueue<>((n1, n2) -> {
			if (n1[0] == n2[0]) return n1[1] - n2[1];
			return n1[0] - n2[0];
		});
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			if (n1 > n2) pq.add(new int[]{n2, n1});
		}
	}
}
