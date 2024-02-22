package Q10868_최솟값;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N, M, r, a[], g[], INF = (int) 1e9 + 4;
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
			int st = Integer.parseInt(stk.nextToken()) - 1;
			int ed = Integer.parseInt(stk.nextToken()) - 1;

			int ret = query(st, ed);
			sb.append(ret).append("\n");
		}
	}

	private void input() throws Exception {
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		r = (int) Math.sqrt(N);

		g = new int[N % r != 0 ? N / r + 1 : N / r];
		for (int i = 0; i < N; i++) {
			if (i % r == 0) g[i / r] = a[i];
			else g[i / r] = Math.min(g[i / r], a[i]);
		}
	}

	private int query(int st, int ed) {
		int ret = a[st];

		if (st / r == ed / r) {
			for (int i = st+1; i <= ed; i++) {
				ret = Math.min(ret, a[i]);
			}
			return ret;
		}

		while (st % r != 0) ret = Math.min(ret, a[++st]);
		while (ed % r != r - 1) ret = Math.min(ret, a[ed--]);


		int st_g = st / r;
		int ed_g = ed / r;

		for (int i = st_g; i <= ed_g; i++) {
			ret = Math.min(ret, g[i]);
		}

		return ret;
	}
}
