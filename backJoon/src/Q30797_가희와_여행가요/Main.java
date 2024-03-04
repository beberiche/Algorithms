package Q30797_가희와_여행가요;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int N, Q, a[][], p[], err = -1, cnt;
	private long[] ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(cnt != N - 1 ? err : ans[0] + " " + ans[1]);
	}

	private void solve() {
		Arrays.sort(a, (n1, n2) -> {
			if (n1[2] == n2[2]) return n1[3] - n2[3];
			return n1[2] - n2[2];
		});

		cnt = 0;
		ans = new long[2];
		for (int i = 0; i < a.length; i++) {
			int x = find(a[i][0]);
			int y = find(a[i][1]);

			if (x != y) {
				if (x < y) {
					p[y] = x;
				} else {
					p[x] = y;
				}

				cnt++;
				ans[0] = Math.max(ans[0], a[i][3]);
				ans[1] += a[i][2];
				if (cnt == N - 1) break;
			}
		}
	}

	private int find(int n) {
		if (p[n] == n) return n;
		return p[n] = find(p[n]);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		Q = Integer.parseInt(stk.nextToken());

		p = new int[N + 1];
		for (int i = 1; i < N; i++) {
			p[i] = i;
		}

		a = new int[Q][4];
		for (int i = 0; i < Q; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());
			int time = Integer.parseInt(stk.nextToken());

			a[i] = new int[]{n1, n2, cost, time};
		}
	}
}
