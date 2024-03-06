package Q30459_현수막_걸기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private Set<Integer> s;
	private int N, M, R, a[], poll[];
	private double ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		if (ans == -1) {
			System.out.print(-1);
		} else {
			System.out.printf("%.1f", ans);
		}

	}

	private void solve() {
		ans = -1;
		s = new HashSet<>();
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int dist = a[j] - a[i];
				if (s.contains(dist)) continue;

				int idx = binarySearch(dist);
				if (idx != -1) ans = Math.max(ans, dist * 1D * poll[idx] / 2);

				s.add(dist);
			}
		}
	}

	private int binarySearch(int dist) {
		int l = 0;
		int r = M - 1;
		int ret = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (poll[mid] * 1D * dist / 2 <= R) {
				ret = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ret;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());

		a = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(a);


		poll = new int[M];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			poll[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(poll);
	}
}
