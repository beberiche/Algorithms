package Q22862_가장_긴_짝수_연속한_부분_수열_large;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, K, a[], ans;
	private List<Integer> list;

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
		if (list.size() <= K + 2) {
			ans = N - list.size() + 2;
		} else {
			int l = 1;
			int r = K + 1;
			int prev = list.get(l) - list.get(l - 1);
			int next = list.get(r) - list.get(l);
			ans = prev + next - (K - 1);

			while (++l < ++r && r < list.size()) {
				prev = list.get(l) - list.get(l - 1);
				next = list.get(r) - list.get(l);
				ans = Math.max(ans, prev + next - (K - 1));
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		a = new int[N + 1];
		stk = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		list.add(0);
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			if (a[i] % 2 == 1) {
				list.add(i);
			}
		}
		list.add(N + 1);
	}
}
