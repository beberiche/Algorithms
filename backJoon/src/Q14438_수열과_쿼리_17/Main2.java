package Q14438_수열과_쿼리_17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main2 {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private StringBuilder sb = new StringBuilder();
	private int a[], tree[], idx, newVal, l, r;

	public static void main(String[] args) throws Exception {
		Main2 m = new Main2();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() throws Exception {
		int M = Integer.parseInt(br.readLine());
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
				int ret = segmentTree_query(1, 0, a.length - 1);
				sb.append(ret).append("\n");
			}
		}
	}


	private void input() throws Exception {
		int N = Integer.parseInt(br.readLine());
		a = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		int H = (int) ceil(log(N) / log(2));
		int treeSize = 1 << (H + 1);
		tree = new int[treeSize];
		segmentTree_init(1, 0, N - 1);
	}

	private void segmentTree_init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx] = a[st];
			return;
		}

		int mid = (st + ed) / 2;
		segmentTree_init(nodeIdx * 2, st, mid);
		segmentTree_init(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = Math.min(tree[nodeIdx * 2], tree[nodeIdx * 2 + 1]);
	}

	private int segmentTree_query(int nodeIdx, int st, int ed) {
		if (r < st || ed < l) {
			return Integer.MAX_VALUE;
		}

		if (l <= st && ed <= r) {
			return tree[nodeIdx];
		}


		int mid = (st + ed) / 2;

		int ret1 = segmentTree_query(nodeIdx * 2, st, mid);
		int ret2 = segmentTree_query(nodeIdx * 2 + 1, mid + 1, ed);
		return Math.min(ret1, ret2);
	}

	private void segmentTree_update(int nodeIdx, int st, int ed) {
		if (idx < st || idx > ed) return;

		if (st == ed) {
			a[idx] = newVal;
			tree[nodeIdx] = newVal;
			return;
		}

		int mid = (st + ed) / 2;
		segmentTree_update(nodeIdx * 2, st, mid);
		segmentTree_update(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = Math.min(tree[nodeIdx * 2], tree[nodeIdx * 2 + 1]);
	}
}
