package Q23743_방탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, M, p[], g[][], ans;

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
		Arrays.sort(g, (n1, n2) -> n1[2] - n2[2]);

		int cnt = 0;
		for (int i = 0; i < g.length; i++) {
			if (cnt >= N) break;
			int x = find(g[i][0]);
			int y = find(g[i][1]);

			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}

			if (x != y) {
				p[y] = x;
				ans += g[i][2];
				cnt++;
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
		M = Integer.parseInt(stk.nextToken());


		g = new int[M + N][3];
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			g[i] = new int[]{n1, n2, dist};
		}

		stk = new StringTokenizer(br.readLine());

		int idx = M;
		for (int i = 1; i <= N; i++) {
			g[idx++] = new int[]{i, 0, Integer.parseInt(stk.nextToken())};
		}

		p = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
	}
}