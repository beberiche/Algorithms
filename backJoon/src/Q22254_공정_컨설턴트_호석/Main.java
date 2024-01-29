package Q22254_공정_컨설턴트_호석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private int N, X, ans;
	private long a[];

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
		int l = 1;
		int r = N;
		while (l < r) {
			int mid = (l + r) / 2;
			if (go(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		ans = r;
	}

	private boolean go(int mid) {
		long currT = 0;
		int idx = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < mid; i++) {
			pq.add(a[idx++]);
		}

		while (idx < N) {
			currT = pq.peek();
			int cnt = 0;
			while (!pq.isEmpty() && currT == pq.peek()) {
				pq.poll();
				cnt++;
			}
			for (int i = 0; i < cnt; i++) {
				pq.add(a[idx++] + currT);
				if (idx >= N) break;
			}
		}

		while (!pq.isEmpty()) {
			currT = pq.poll();
		}

		return currT <= X;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		X = Integer.parseInt(stk.nextToken());
		a = new long[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(stk.nextToken());
		}

	}
}
