package Q1351_무한_수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private HashMap<Long, Long> m = new HashMap();
	private long N, P, Q, ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();

	}

	private void output() {
		System.out.println(ans);
	}

	private void solve() {
		ans = go(N);
	}

	private long go(long num) {
		if (num == 0) return 1;
		if (m.containsKey(num)) return m.get(num);

		long p = num / P;
		long q = num / Q;

		m.put(num, go(p) + go(q));
		return m.get(num);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Long.parseLong(stk.nextToken());
		P = Integer.parseInt(stk.nextToken());
		Q = Integer.parseInt(stk.nextToken());
	}
}
