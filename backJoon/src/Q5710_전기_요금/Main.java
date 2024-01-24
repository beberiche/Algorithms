package Q5710_전기_요금;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long[] a = {2, 3, 5}, aa = {100, 9900, 990000};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());

			if (A == 0 && B == 0) return;

			int W = getPower(A);
			long ret = go(W, B);
			System.out.println(ret);
		}
	}

	private static long go(int W, int B) {
		int l = 0;
		int r = W;

		while (l < r) {
			int mid = (l + r) / 2;
			long cost1 = getCost(mid);
			long cost2 = getCost(W - mid);
			long cmp = Math.abs(cost1 - cost2);
			if (cmp < B) {
				r = mid - 1;
			} else if (cmp > B) {
				l = mid + 1;
			} else {
				return Math.min(cost1, cost2);
			}
		}
		return -1;
	}

	private static int getPower(int A) {
		int remain = A;
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			if (remain > a[i] * aa[i]) {
				sum += aa[i];
				remain -= a[i] * aa[i];
			} else {
				sum += remain / a[i];
				remain = 0;
			}
		}
		sum += remain / 7;
		return sum;
	}

	private static long getCost(int W) {
		long remain = W;
		long sum = 0;

		for (int i = 0; i < 3; i++) {
			if (remain > aa[i]) {
				sum += a[i] * aa[i];
				remain -= aa[i];
			} else {
				sum += a[i] * remain;
				remain = 0;
			}
		}

		sum += remain * 7;
		return sum;
	}
}
