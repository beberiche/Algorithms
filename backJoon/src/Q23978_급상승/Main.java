package Q23978_급상승;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	int N, a[];
	long K, ans;

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
		long l = 1;
		long r = (long) 3e9 / 2;

		while (l <= r) {
			long mid = (l + r) / 2;
			if (go(mid)) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
	}

	private boolean go(long mid) {
		long sum = mid * (mid + 1) / 2;
		for (int i = 0; i < N - 1; i++) {
			long diff = Math.min(mid, a[i + 1] - a[i]);
			sum += mid * diff - (diff - 1) * diff / 2;
		}
		return sum >= K;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Long.parseLong(stk.nextToken());
		a = new int[N];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
	}
}
