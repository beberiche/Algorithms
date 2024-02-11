package Q2042_구간_합_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long a[], tree[], newVal;
	private static int l, r, idx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		a = new long[N];


		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(br.readLine());
		}

		int H = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[1 << (H + 1)];
		init(1, 0, N - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());

			if (cmd == 1) {
				idx = Integer.parseInt(stk.nextToken()) - 1;
				newVal = Long.parseLong(stk.nextToken());
				update(1, 0, N - 1);
			} else {
				l = Integer.parseInt(stk.nextToken()) - 1;
				r = Integer.parseInt(stk.nextToken()) - 1;
				sb.append(query(1, 0, N - 1)).append("\n");
			}
		}
		System.out.print(sb.toString());
	}


	private static void init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx] = a[st];
			return;
		}

		int mid = (st + ed) / 2;
		init(nodeIdx * 2, st, mid);
		init(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}

	private static void update(int nodeIdx, int st, int ed) {
		if (idx < st || idx > ed) return;

		if (st == ed) {
			a[idx] = newVal;
			tree[nodeIdx] = newVal;
			return;
		}

		int mid = (st + ed) / 2;
		update(nodeIdx * 2, st, mid);
		update(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}

	private static long query(int nodeIdx, int st, int ed) {
		if (ed < l || st > r) return 0;

		if (l <= st && ed <= r) return tree[nodeIdx];

		int mid = (st + ed) / 2;
		return query(nodeIdx * 2, st, mid) + query(nodeIdx * 2 + 1, mid + 1, ed);
	}
}
