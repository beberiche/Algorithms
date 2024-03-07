package Q1725_히스토그램;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private int N, a[], t[], INF = (int) 1e9 + 4;
	private long ans;

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
		ans = go(0, N - 1);
	}

	private long go(int st, int ed) {
		if (st == ed) {
			return a[st] * 1L;
		}

		int idx = query(1, 0, N - 1, st, ed);
		int range = ed - st + 1;
		long ret = range * 1L * a[idx];

		if (st < idx) ret = Math.max(ret, go(st, idx-1));
		if (idx < ed) ret = Math.max(ret, go(idx + 1, ed));

		return ret;
	}

	private int query(int nodeIdx, int st, int ed, int l, int r) {
		if (r < st || ed < l) return N;

		if (l <= st && ed <= r) return t[nodeIdx];

		int mid = (st + ed) / 2;
		int lIdx = nodeIdx * 2;
		int rIdx = nodeIdx * 2 + 1;

		int left = query(lIdx, st, mid, l, r);
		int right = query(rIdx, mid + 1, ed, l, r);

		return a[left] <= a[right] ? left : right;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N + 1];

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		a[N] = INF;

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		t = new int[1 << (h + 1)];

		init(1, 0, N - 1);
	}

	private void init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			t[nodeIdx] = st;
			return;
		}

		int mid = (st + ed) / 2;
		int lIdx = nodeIdx * 2;
		int rIdx = nodeIdx * 2 + 1;
		init(lIdx, st, mid);
		init(rIdx, mid + 1, ed);
		t[nodeIdx] = a[t[lIdx]] <= a[t[rIdx]] ? t[lIdx] : t[rIdx];
	}
}
