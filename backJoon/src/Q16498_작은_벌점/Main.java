package Q16498_작은_벌점;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int A, B, C, a[], b[], c[], ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private void go(int ret_a, int ret_b, int ret_c) {
		int max = Math.max(ret_a, Math.max(ret_b, ret_c));
		int min = Math.min(ret_a, Math.min(ret_b, ret_c));

		ans = Math.min(ans, max - min);
	}

	private void solve() {
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < A; i++) {
			go(a[i], lowerBound(b, a[i]), lowerBound(c, a[i]));
		}

		for (int i = 0; i < B; i++) {
			go(lowerBound(a, b[i]), b[i], lowerBound(c, b[i]));
		}

		for (int i = 0; i < C; i++) {
			go(lowerBound(a, c[i]), lowerBound(b, c[i]), c[i]);
		}
	}

	private int lowerBound(int[] cards, int cmp) {
		int l = 0;
		int r = cards.length-1;

		while (l < r) {
			int mid = (l + r) / 2;
			if (cards[mid] >= cmp) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		return cards[r];
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());

		a = new int[A];
		b = new int[B];
		c = new int[C];

		cardSet(a, br);
		cardSet(b, br);
		cardSet(c, br);
	}

	private void cardSet(int[] cards, BufferedReader br) throws Exception {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < cards.length; i++) {
			cards[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(cards);
	}
}
