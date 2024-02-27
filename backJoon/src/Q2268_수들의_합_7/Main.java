package Q2268_수들의_합_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private StringBuilder sb = new StringBuilder();
	private int N, M, a[];
	private long tree[];

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
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			if (cmd == 0) {
				if (n1 > n2) {
					int tmp = n1;
					n1 = n2;
					n2 = tmp;
				}
				long ret = sum(1, 0, N - 1, n1 - 1, n2 - 1);
				sb.append(ret).append("\n");
			} else {
				modify(1, 0, N - 1, n1 - 1, n2);
			}
		}
	}

	private long sum(int nodeIdx, int st, int ed, int l, int r) {
		if (ed < l || r < st) {
			return 0;
		}

		if (l <= st && ed <= r) {
			return tree[nodeIdx];
		}

		int mid = (st + ed) / 2;
		long left = sum(nodeIdx * 2, st, mid, l, r);
		long right = sum(nodeIdx * 2 + 1, mid + 1, ed, l, r);
		return left + right;
	}

	private void modify(int nodeIdx, int st, int ed, int idx, int newVal) {
		if (idx < st || ed < idx) {
			return;
		}

		if (st == ed) {
			a[idx] = newVal;
			tree[nodeIdx] = 1L * newVal;
			return;
		}

		int mid = (st + ed) / 2;
		modify(nodeIdx * 2, st, mid, idx, newVal);
		modify(nodeIdx * 2 + 1, mid + 1, ed, idx, newVal);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}

	private void input() throws Exception {
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[N];
		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[1 << (H + 1)];
	}
}
