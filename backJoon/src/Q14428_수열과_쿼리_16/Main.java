package Q14428_수열과_쿼리_16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private StringBuilder sb = new StringBuilder();
	private int a[], d[][], sqrt, idx, newVal, l, r;

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
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			if (cmd == 1) {
				idx = Integer.parseInt(stk.nextToken()) - 1;
				newVal = Integer.parseInt(stk.nextToken());
				sqrtDecomposition_update();
			} else {
				l = Integer.parseInt(stk.nextToken()) - 1;
				r = Integer.parseInt(stk.nextToken()) - 1;
				sb.append(sqrtDecomposition_query()[1] + 1).append("\n");
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

		sqrtDecomposition_init();
	}

	private int[] sqrtDecomposition_query() {
		int[] ret = {a[l], l};

		// 그룹이 같은 경우
		if (l / sqrt == r / sqrt) {
			for (int i = l; i <= r; i++) {
				if (ret[0] > a[i]) {
					ret[0] = a[i];
					ret[1] = i;
				} else if (ret[0] == a[i] && ret[1] > i) {
					ret[0] = a[i];
					ret[1] = i;
				}
			}
			return ret;
		}

		while (l % sqrt != 0) {
			if (ret[0] > a[l]) {
				ret[0] = a[l];
				ret[1] = l;
			} else if (ret[0] == a[l] && ret[1] > l) {
				ret[0] = a[l];
				ret[1] = l;
			}
			l++;
		}

		while (r % sqrt != sqrt - 1) {
			if (ret[0] > a[r]) {
				ret[0] = a[r];
				ret[1] = r;
			} else if (ret[0] == a[r] && ret[1] > r) {
				ret[0] = a[r];
				ret[1] = r;
			}
			r--;
		}

		int st = l / sqrt;
		int ed = r / sqrt;

		for (int i = st; i <= ed; i++) {
			if (ret[0] > d[i][0]) {
				ret[0] = d[i][0];
				ret[1] = d[i][1];
			} else if (ret[0] == d[i][0] && ret[1] > d[i][1]) {
				ret[0] = d[i][0];
				ret[1] = d[i][1];
			}
		}


		return ret;
	}


	private void sqrtDecomposition_update() {
		a[idx] = newVal;
		int g = idx / sqrt;
		int st = g * sqrt;
		int ed = st + sqrt - 1 > a.length - 1 ? a.length - 1 : st + sqrt - 1;
		d[g][0] = a[st];
		d[g][1] = st;
		for (int i = st; i <= ed; i++) {
			if (d[g][0] > a[i]) {
				d[g][0] = a[i];
				d[g][1] = i;
			} else if (d[g][0] == a[i] && d[g][1] > i) {
				d[g][0] = a[i];
				d[g][1] = i;
			}
		}
	}

	private void sqrtDecomposition_init() {
		sqrt = (int) Math.floor(Math.sqrt(a.length));
		int g = a.length / sqrt;
		if (a.length % sqrt != 0) g++;
		d = new int[g][2];

		for (int i = 0; i < a.length; i++) {
			if (i % sqrt == 0) {
				d[i / sqrt][0] = a[i];
				d[i / sqrt][1] = i;
			} else if (d[i / sqrt][0] > a[i]) {
				d[i / sqrt][0] = a[i];
				d[i / sqrt][1] = i;
			} else if (d[i / sqrt][0] == a[i] && d[i / sqrt][1] > i) {
				d[i / sqrt][0] = a[i];
				d[i / sqrt][1] = i;
			}
		}
	}
}
