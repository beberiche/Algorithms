package Q27977_킥보드로_등교하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int L, N, K, a[], diff, ans;

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
		int l = diff;
		int r = L;

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

	private boolean go(int power) {
		int cnt = 0;
		int p = power;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i + 1] - a[i] > p) {
				p = power;
				cnt++;
				if (cnt > K) return false;
			}
			p -= (a[i + 1] - a[i]);
		}

		return cnt <= K;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		a = new int[N + 2];
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			diff = Math.max(diff, a[i] - a[i - 1]);
		}
		a[N + 1] = L;
		diff = Math.max(diff, a[N + 1] - a[N]);
		Arrays.sort(a);
	}
}
