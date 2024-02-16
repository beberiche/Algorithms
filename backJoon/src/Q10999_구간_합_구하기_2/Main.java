package Q10999_구간_합_구하기_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private long a[], tree[], lazy[], l, r, newVal;
	private int N, M;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
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
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			l = Long.parseLong(stk.nextToken()) - 1;
			r = Long.parseLong(stk.nextToken()) - 1;
			if (cmd == 1) {
				newVal = Long.parseLong(stk.nextToken());
				segment_tree_update_range(1, 0, N - 1);
			} else {
				long ans = segment_tree_query(1, 0, N - 1);
				sb.append(ans).append("\n");
			}
		}
	}


	private void input() throws Exception {
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());

		a = new long[N];
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(br.readLine());
		}
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_size = 1 << (H + 1);

		tree = new long[tree_size];
		lazy = new long[tree_size];

		segment_tree_init(1, 0, N - 1);
	}

	private long segment_tree_query(int nodeIdx, int st, int ed) {
		segment_tree_update_lazy(nodeIdx, st, ed);
		if (l > ed || r < st) return 0;

		if (l <= st && ed <= r) return tree[nodeIdx];

		int mid = (st + ed) >> 1;
		return segment_tree_query(nodeIdx * 2, st, mid) + segment_tree_query(nodeIdx * 2 + 1, mid + 1, ed);
	}

	private void segment_tree_update_range(int nodeIdx, int st, int ed) {
		segment_tree_update_lazy(nodeIdx, st, ed);
		if (l > ed || r < st) return;

		if (l <= st && ed <= r) {
			tree[nodeIdx] += (ed - st + 1) * newVal;
			if (st != ed) {
				lazy[nodeIdx * 2] += newVal;
				lazy[nodeIdx * 2 + 1] += newVal;
			}
			return;
		}

		int mid = (st + ed) >> 1;
		segment_tree_update_range(nodeIdx * 2, st, mid);
		segment_tree_update_range(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}

	private void segment_tree_update_lazy(int nodeIdx, int st, int ed) {
		if (lazy[nodeIdx] != 0) {
			tree[nodeIdx] += (ed - st + 1) * lazy[nodeIdx];
			if (st != ed) {
				lazy[nodeIdx * 2] += lazy[nodeIdx];
				lazy[nodeIdx * 2 + 1] += lazy[nodeIdx];
			}
			lazy[nodeIdx] = 0;
		}
	}

	private void segment_tree_init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx] = a[st];
			return;
		}

		int mid = (st + ed) >> 1;
		segment_tree_init(nodeIdx * 2, st, mid);
		segment_tree_init(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}
}
