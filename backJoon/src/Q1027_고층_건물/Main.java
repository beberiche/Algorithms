package Q1027_고층_건물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int cnt[];
	private double a[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		int ans = 0;
		for (int i = 0; i < cnt.length; i++) {
			ans = Math.max(cnt[i], ans);
		}
		System.out.println(ans);
	}

	private void solve() {
		int INF = ((int) 1e9 + 4) * -1;
		cnt = new int[a.length];
		for (int i = 0; i < a.length - 1; i++) {
			double s = INF;
			for (int j = i + 1; j < a.length; j++) {
				double cs = (a[i] - a[j]) / (i - j);
				if (s < cs) {
					s = cs;
					cnt[i]++;
					cnt[j]++;
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		a = new double[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
	}
}
