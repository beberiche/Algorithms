package Q1517_버블_소트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		Map<Integer, Queue<Integer>> m = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!m.containsKey(a[i])) m.put(a[i], new LinkedList<>());
			m.get(a[i]).add(i);
		}

		int[] idx = a.clone();
		Arrays.sort(idx);
		long[] t = new long[getTreeSize(N)];

		long ans = 0;
		for (int i = 0; i < N; i++) {
			int curr = m.get(idx[i]).poll();
			ans += sum(t, 0, N - 1, 1, curr, N - 1);
			update(t, 0, N - 1, 1, curr, 1);
		}

		System.out.println(ans);

	}

	private static void update(long[] t, int st, int ed, int node, int curr, int val) {
		if (curr < st || curr > ed) return;

		if (st == ed) {
			t[node] = val;
			return;
		}

		int mid = (st + ed) / 2;

		update(t, st, mid, node * 2, curr, val);
		update(t, mid + 1, ed, node * 2 + 1, curr, val);
		t[node] = t[node * 2] + t[node * 2 + 1];
	}

	private static long sum(long[] t, int st, int ed, int node, int left, int right) {
		if (ed < left || st > right) return 0;

		if (left <= st && ed <= right) {
			return t[node];
		}

		int mid = (st + ed) / 2;
		long l = sum(t, st, mid, node * 2, left, right);
		long r = sum(t, mid + 1, ed, node * 2 + 1, left, right);
		return l + r;
	}

	private static int getTreeSize(int N) {
		int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		return 1 << h;
	}
}
