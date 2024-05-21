package Q27172_수_나누기_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N, a[], idx[], ans[], INF = (int) 1e6 + 1;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.print(sb.toString());
	}

	private void solve() {
		ans = new int[N];
		for (int i = 0; i < N; i++) {
			int x = a[i];
			for (int j = 2 * x; j < INF; j += x) {
				if (idx[j] != 0) {
					ans[i]++;
					ans[idx[j] - 1]--;
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		idx = new int[INF];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			idx[a[i]] = i + 1;
		}
	}
}
