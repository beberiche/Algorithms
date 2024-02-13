package Q11505_구간_곱_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private StringBuilder sb = new StringBuilder();
	private int a[], M, MOD = (int) (1e9 + 7), idx, newVal, l, r;
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
			if (cmd == 1) {
				idx = Integer.parseInt(stk.nextToken()) - 1;
				newVal = Integer.parseInt(stk.nextToken());
				segmentTree_update(1, 0, a.length - 1);
			} else {
				l = Integer.parseInt(stk.nextToken()) - 1;
				r = Integer.parseInt(stk.nextToken()) - 1;
				sb.append(segmentTree_query(1, 0, a.length - 1)).append("\n");
			}
		}
	}


	private void input() throws Exception {
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		a = new int[N];
		M = Integer.parseInt(stk.nextToken());
		M += Integer.parseInt(stk.nextToken());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_size = 1 << (H + 1);

		tree = new long[tree_size];
		segmentTree_init(1, 0, N - 1);
	}

	private void segmentTree_init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx] = a[st];
			return;
		}

		int mid = (st + ed) / 2;
		segmentTree_init(nodeIdx * 2, st, mid);
		segmentTree_init(nodeIdx * 2+1, mid + 1, ed);
		tree[nodeIdx] = (tree[nodeIdx * 2] * tree[nodeIdx * 2 + 1]) % MOD;
	}

	private void segmentTree_update(int nodeIdx, int st, int ed) {
		if (idx < st || ed < idx) {
			return;
		}

		if (st == ed) {
			tree[nodeIdx] = newVal;
			a[idx] = newVal;
			return;
		}
		int mid = (st + ed) / 2;
		segmentTree_update(nodeIdx * 2, st, mid);
		segmentTree_update(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = (tree[nodeIdx * 2] * tree[nodeIdx * 2 + 1]) % MOD;
	}


	private long segmentTree_query(int nodeIdx, int st, int ed) {
		if (l > ed || r < st) {
			return 1;
		}

		if (l <= st && ed <= r) {
			return tree[nodeIdx];
		}

		int mid = (st + ed) / 2;
		return (segmentTree_query(nodeIdx * 2, st, mid) * segmentTree_query(nodeIdx * 2 + 1, mid + 1, ed)) % MOD;
	}
}
