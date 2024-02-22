package Q14427_수열과_쿼리_15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private int a[];
	private PriorityQueue<int[]> pq;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() throws Exception {
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			if (cmd == 1) {
				int idx = Integer.parseInt(stk.nextToken())-1;
				int val = Integer.parseInt(stk.nextToken());

				a[idx] = val;
				pq.add(new int[]{idx, val});
			} else {
				while (true) {
					int[] curr = pq.peek();
					if (a[curr[0]] != curr[1]) pq.poll();
					else {
						sb.append(curr[0]+1).append("\n");
						break;
					}
				}
			}
		}
	}

	private void input() throws Exception {
		int N = Integer.parseInt(br.readLine());
		a = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>((n1, n2) -> {
			if (n1[1] == n2[1]) {
				return n1[0] - n2[0];
			}
			return n1[1] - n2[1];
		});
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			pq.add(new int[]{i, a[i]});
		}
	}
}
