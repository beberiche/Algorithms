package Q24041_성싶당_밀키트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	long N, G, K, ans;
	List<long[]> req, unReq;
	PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

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
		long l = 0;
		long r = (long) (2e9);
		ans = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			if (go(mid)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1 ;
			}
		}
	}

	private boolean go(long mid) {
		long sum = 0;

		for (int i = 0; i < req.size(); i++) {
			long s = req.get(i)[0];
			long l = req.get(i)[1];
			sum += s * Math.max(1, mid - l);
			if (sum > G) return false;
		}

		for (int i = 0; i < unReq.size(); i++) {
			long s = unReq.get(i)[0];
			long l = unReq.get(i)[1];
			long ret = s * Math.max(1, mid - l);
			sum += ret;
			pq.add(ret);
		}

		for (int i = 0; i < K && !pq.isEmpty(); i++) {
			sum -= pq.poll();
		}

		if (!pq.isEmpty()) pq.clear();
		return sum <= G;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Long.parseLong(stk.nextToken());
		G = Long.parseLong(stk.nextToken());
		K = Long.parseLong(stk.nextToken());

		req = new ArrayList<>();
		unReq = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			long s = Long.parseLong(stk.nextToken());
			long l = Long.parseLong(stk.nextToken());
			long o = Long.parseLong(stk.nextToken());

			if (o == 0) req.add(new long[]{s, l});
			else unReq.add(new long[]{s, l});
		}
	}
}
