package Q14438_수열과_쿼리_17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private int r, a[], d[], st, ed, idx, newVal;
	private StringBuilder sb = new StringBuilder();

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
				st = Integer.parseInt(stk.nextToken()) - 1;
				ed = Integer.parseInt(stk.nextToken()) - 1;
				int ans = sqrtDecomposition_query();
				sb.append(ans).append("\n");
			}
		}
	}


	void input() throws Exception {
		a = new int[Integer.parseInt(br.readLine())];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		sqrtDecomposition_init();
	}

	private void sqrtDecomposition_init() {
		int N = a.length;
		r = (int) floor(sqrt(N));
		int g = N / r;
		d = new int[N % r != 0 ? g + 1 : g];
		for (int i = 0; i < N; i++) {
			if (i % r == 0) d[i / r] = a[i];
			else d[i / r] = Math.min(d[i / r], a[i]);
		}
	}

	private void sqrtDecomposition_update() {
		a[idx] = newVal;
		int curr_g = idx / r;
		int st = curr_g * r;
		int ed = st + r > a.length ? a.length : st + r;
		d[curr_g] = a[st];
		for (int i = st; i < ed; i++) {
			d[curr_g] = Math.min(d[curr_g], a[i]);
		}
	}

	private int sqrtDecomposition_query() {
		int ret = a[st];
		if (st / r == ed / r) {
			for (int i = st; i <= ed; i++) {
				ret = Math.min(ret, a[i]);
			}
			return ret;
		}


		// l에 속한 그룹
		while (st % r != 0) ret = Math.min(a[st++], ret);

		// r에 속한 그룹
		while (ed % r != r - 1) ret = Math.min(a[ed--], ret);

		// l~r 두 사이의 그룹
		int st_g = st / r;
		int ed_g = ed / r;

		for (int i = st_g; i <= ed_g; i++) {
			ret = Math.min(ret, d[i]);
		}

		return ret;
	}
}
