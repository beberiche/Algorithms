package Q1275_커피숍2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int a[], N, M;

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer stk;

	public static void main(String[] args) throws Exception {
		input();
		SegmentTree s = new SegmentTree();
		SqrtDecomposition sd = new SqrtDecomposition();


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(stk.nextToken()) - 1;
			int r = Integer.parseInt(stk.nextToken()) - 1;
			if (l > r) {
				int tmp = l;
				l = r;
				r = tmp;
			}
//			long ret1 = s.query(1, 0, N - 1, l, r);
			long ret2 = sd.query(l, r);

			int idx = Integer.parseInt(stk.nextToken()) - 1;
			int newVal = Integer.parseInt(stk.nextToken());

//			s.update(1, 0, N - 1, idx, newVal);
			sd.update(idx, newVal);

//			sb.append(ret1).append("\n");
			sb.append(ret2).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void input() throws Exception {
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
	}

	static class SqrtDecomposition {
		private long d[];
		private int sqrt;

		SqrtDecomposition() {
			sqrt = (int) Math.sqrt(N);
			int g = N / sqrt;
			if (N % sqrt != 0) g++;
			d = new long[g];
			for (int i = 0; i < N; i++) {
				if (i % sqrt == 0) d[i / sqrt] = a[i];
				else d[i / sqrt] += a[i];
			}
		}

		public long query(int l, int r) {
			long ret = 0;
			if (l / sqrt == r / sqrt) {
				for (int i = l; i <= r; i++) {
					ret += a[i];
				}
				return ret;
			}

			while (l % sqrt != 0) ret += a[l++];
			while (r % sqrt != sqrt - 1) ret += a[r--];

			int st_g = l / sqrt;
			int ed_g = r / sqrt;

			for (int i = st_g; i <= ed_g; i++) {
				ret += d[i];
			}
			return ret;
		}

		public void update(int idx, int newVal) {
			a[idx] = newVal;
			int curr_g = idx / sqrt;
			int st = curr_g * sqrt;
			int ed = st + sqrt > a.length ? a.length : st + sqrt;

			long ret = 0;
			for (int i = st; i < ed; i++) {
				ret += a[i];
			}
			d[curr_g] = ret;
		}
	}

	static class SegmentTree {
		private long tree[];

		SegmentTree() {
			int h = (int) Math.ceil(Math.log(N) / Math.log(2));
			tree = new long[1 << (h + 1)];
			init(1, 0, N - 1);
		}

		private void init(int nodeIdx, int st, int ed) {
			if (st == ed) {
				tree[nodeIdx] = a[st];
				return;
			}

			int mid = (st + ed) / 2;
			init(nodeIdx * 2, st, mid);
			init(nodeIdx * 2 + 1, mid + 1, ed);
			tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
		}

		public long query(int nodeIdx, int st, int ed, int l, int r) {
			if (r < st || ed < l) {
				return 0;
			}

			if (l <= st && ed <= r) {
				return tree[nodeIdx];
			}

			int mid = (st + ed) / 2;
			long left = query(nodeIdx * 2, st, mid, l, r);
			long right = query(nodeIdx * 2 + 1, mid + 1, ed, l, r);
			return left + right;
		}

		public void update(int nodeIdx, int st, int ed, int idx, int newVal) {
			if (st > idx || ed < idx) return;

			if (st == ed) {
				a[idx] = newVal;
				tree[nodeIdx] = newVal;
				return;
			}

			int mid = (st + ed) / 2;
			update(nodeIdx * 2, st, mid, idx, newVal);
			update(nodeIdx * 2 + 1, mid + 1, ed, idx, newVal);
			tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
		}
	}
}
