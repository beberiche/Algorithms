package Q28793_Double_It;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private long min, max, diff;
	private PriorityQueue<Long> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();

	}

	private void output() {
		System.out.println(diff);
	}

	private void solve() {
		diff = Long.MAX_VALUE;
		long goal = max;
		long curr;
		while ((curr = pq.poll()) != goal) {
			diff = Math.min(diff, max - curr);
			long next = curr * 2;
			max = Math.max(next, max);
			pq.add(next);
		}
		diff = Math.min(diff, max - curr);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());


		StringTokenizer stk = new StringTokenizer(br.readLine());
		min = Long.MAX_VALUE;
		long[] a = new long[N];
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(stk.nextToken());
			a[i] = num;
			max = Math.max(num, max);
		}

		for (int i = 0; i < N; i++) {
			long num = a[i];
			while ((num *= 2) <= max) {}
			pq.add(num / 2);
		}
	}
}
