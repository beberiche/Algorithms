package Q6549_히스토그램에서_가장_큰_직사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private int N, a[], tree[];
	private long ans;
	private StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.excute();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void excute() throws Exception {
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			if (N == 0) break;
			a = new int[N + 1];

			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(stk.nextToken());
			}

			a[N] = Integer.MAX_VALUE;
			int H = (int) Math.ceil(Math.log(N) / Math.log(2));
			tree = new int[1 << (H + 1)];
			ans = 0;
			segment_tree(1, 0, N - 1);

			go(0, N - 1);
			sb.append(ans).append("\n");
		}
	}

	private void go(int st, int ed) {
		if (st == ed) {
			ans = Math.max(ans, a[st]);
		} else if (st < ed) {
			int idx = segment_tree_query(1, 0, N - 1, st, ed);
			ans = Math.max(ans, (ed - st + 1) * 1L * a[idx]);
			go(st, idx - 1);
			go(idx + 1, ed);
		}

	}

	private void segment_tree(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx] = st;
			return;
		}

		int mid = (st + ed) / 2;
		segment_tree(nodeIdx * 2, st, mid);
		segment_tree(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = a[tree[nodeIdx * 2]] <= a[tree[nodeIdx * 2 + 1]] ? tree[nodeIdx * 2] : tree[nodeIdx * 2 + 1];
	}

	private int segment_tree_query(int nodeIdx, int st, int ed, int l, int r) {
		if (ed < l || r < st) return N;

		if (l <= st && ed <= r) return tree[nodeIdx];

		int mid = (st + ed) / 2;
		int left = segment_tree_query(nodeIdx * 2, st, mid, l, r);
		int right = segment_tree_query(nodeIdx * 2 + 1, mid + 1, ed, l, r);

		return a[left] <= a[right] ? left : right;
	}
}
