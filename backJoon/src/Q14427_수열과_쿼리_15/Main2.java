package Q14427_수열과_쿼리_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree[][] = new int[1 << (h + 1)][2];
		init(a, tree, 1, 0, N - 1);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			if (cmd == 1) {
				int idx = Integer.parseInt(stk.nextToken()) - 1;
				int newVal = Integer.parseInt(stk.nextToken());
				update(a, tree, 1, 0, N - 1, idx, newVal);
			} else {
				sb.append(tree[1][0]+1).append("\n");
			}
		}

		System.out.print(sb.toString());
	}

	private static void update(int[] a, int[][] tree, int nodeIdx, int st, int ed, int idx, int newVal) {
		if (st > idx || ed < idx) return;

		if (st == ed) {
			a[idx] = newVal;
			tree[nodeIdx][1] = newVal;
			return;
		}

		int mid = (st + ed) / 2;
		update(a, tree, nodeIdx * 2, st, mid, idx, newVal);
		update(a, tree, nodeIdx * 2 + 1, mid + 1, ed, idx, newVal);
		tree[nodeIdx] = calMin(tree[nodeIdx], tree[nodeIdx * 2], tree[nodeIdx * 2 + 1]);
	}

	private static void init(int[] a, int[][] tree, int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx][0] = st;
			tree[nodeIdx][1] = a[st];
			return;
		}

		int mid = (st + ed) / 2;
		init(a, tree, nodeIdx * 2, st, mid);
		init(a, tree, nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = calMin(tree[nodeIdx], tree[nodeIdx * 2], tree[nodeIdx * 2 + 1]);
	}

	private static int[] calMin(int[] node, int[] left, int[] right) {
		if (left[1] == right[1]) {
			node = left[0] < right[0] ? left : right;
		} else {
			node = left[1] < right[1] ? left : right;
		}

		return node;
	}


}
