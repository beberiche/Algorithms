package Q25393_교집합_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, Q;
	private Map<Integer, TreeSet<Integer>> m;

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());

			int ret = go(l, r);
			sb.append(ret).append("\n");
		}
	}


	private int go(int l, int r) {
		if (!m.containsKey(l) || !m.containsKey(r)) {
			return -1;
		}

		Integer ll = m.get(l).ceiling(r);
		Integer rr = m.get(r).floor(l);

		if (ll == null || rr == null) return -1;
		else if (ll == r) return 1;
		else return 2;
	}

	private void input() throws Exception {
		N = Integer.parseInt(br.readLine());

		m = new HashMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());

			if (!m.containsKey(l)) m.put(l, new TreeSet<>());
			m.get(l).add(r);

			if (!m.containsKey(r)) m.put(r, new TreeSet<>());
			m.get(r).add(l);

		}
	}
}
