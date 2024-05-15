package Q20917_사회적_거리_두기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private int n, s, a[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		int t = Integer.parseInt(br.readLine());
		while (--t >= 0) {
			m.input();
			m.solve();
		}
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() {
		int l = 1;
		int r = (int) 1e9 + 4;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (check(mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		sb.append(r).append("\n");
	}

	private boolean check(int mid) {
		int cnt = 1;
		int p = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] - p >= mid) {
				p = a[i];
				cnt++;
			}
		}
//		int i = 0;
//		while (p + mid <= a[a.length - 1]) {
//			int idx = lowerbound(i, p + mid);
//			cnt++;
//			p = a[idx];
//			i = idx;
//		}
		return cnt >= s;
	}

//	private int lowerbound(int i, int val) {
//		int l = i;
//		int r = a.length - 1;
//
//		while (l < r) {
//			int mid = (l + r) / 2;
//			if (a[mid] >= val) {
//				r = mid;
//			} else {
//				l = mid + 1;
//			}
//		}
//
//		return r;
//	}

	private void input() throws Exception {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		s = Integer.parseInt(stk.nextToken());
		a = new int[n];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(a);
	}
}