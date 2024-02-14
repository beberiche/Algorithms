package Q2357_최솟값과_최댓값;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
	private int N, M, a[], tree[][], l, r;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private StringBuilder sb;

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
		sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			l = Integer.parseInt(stk.nextToken()) - 1;
			r = Integer.parseInt(stk.nextToken()) - 1;

			if (l > r) {
				int tmp = l;
				l = r;
				r = tmp;
			}

			int min = query(1, 0, N - 1, true);
			int max = query(1, 0, N - 1, false);

			sb.append(min).append(" ").append(max).append("\n");
		}
	}

	private void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		a = new int[N];

		createTree();
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		init(1, 0, N - 1);

	}

	private int query(int nodeIdx, int st, int ed, boolean isMin) {
		if (st > r || ed < l) return isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;

		if (l <= st && ed <= r) {
			return isMin ? tree[nodeIdx][0] : tree[nodeIdx][1];
		}

		int mid = (st + ed) / 2;
		int left = query(nodeIdx * 2, st, mid, isMin);
		int right = query(nodeIdx * 2 + 1, mid + 1, ed, isMin);
		if (isMin) {
			return Math.min(left, right);
		} else {
			return Math.max(left, right);
		}

	}

	private void init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx][0] = a[st];
			tree[nodeIdx][1] = a[st];
			return;
		}

		int mid = (st + ed) / 2;
		init(nodeIdx * 2, st, mid);
		init(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx][0] = Math.min(tree[nodeIdx * 2][0], tree[nodeIdx * 2 + 1][0]);
		tree[nodeIdx][1] = Math.max(tree[nodeIdx * 2][1], tree[nodeIdx * 2 + 1][1]);
	}

	private void createTree() {
		int H = (int) ceil(log(N) / log(2));
		int treeSize = (1 << (H + 1));
		tree = new int[treeSize][2];
	}
}
