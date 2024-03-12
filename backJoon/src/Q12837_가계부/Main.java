package Q12837_가계부;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long a[], tree[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int Q = Integer.parseInt(stk.nextToken());

		a = new long[N];
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[1 << (h + 1)];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			if (cmd == 1) {
				int p = Integer.parseInt(stk.nextToken()) - 1;
				int x = Integer.parseInt(stk.nextToken());
				update(1, 0, N - 1, p, x);
			} else {
				int p = Integer.parseInt(stk.nextToken()) - 1;
				int q = Integer.parseInt(stk.nextToken()) - 1;
				sb.append(query(1, 0, N - 1, p, q)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	private static long query(int nodeIdx, int st, int ed, int l, int r) {
		if (r < st || ed < l) return 0;

		if (l <= st && ed <= r) {
			return tree[nodeIdx];
		}

		int mid = (st + ed) / 2;
		return query(nodeIdx * 2, st, mid, l, r) + query(nodeIdx * 2 + 1, mid + 1, ed, l, r);
	}

	private static void update(int nodeIdx, int st, int ed, int idx, int val) {
		if (st > idx || ed < idx) return;

		if (st == ed) {
			a[idx] = val;
			tree[nodeIdx] += val;
			return;
		}

		int mid = (st + ed) / 2;
		update(nodeIdx * 2, st, mid, idx, val);
		update(nodeIdx * 2 + 1, mid + 1, ed, idx, val);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}
}
