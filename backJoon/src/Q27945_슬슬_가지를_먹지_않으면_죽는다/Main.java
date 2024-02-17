package Q27945_슬슬_가지를_먹지_않으면_죽는다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int a[][], N, M, d, p[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(d);
	}

	private void solve() {
		Arrays.sort(a, (n1, n2) -> n1[2] - n2[2]);
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		d = 0;
		for (int i = 0; i < a.length; i++) {
			int x = find(a[i][0]);
			int y = find(a[i][1]);


			if (x != y) {
				union(x, y);
				d++;
				if (d != a[i][2]) break;
				if (d == N - 1) {
					d++;
					break;
				}
			}
		}
	}


	private void union(int x, int y) {
		if (x < y) {
			p[y] = x;
		} else {
			p[x] = y;
		}
	}

	private int find(int node) {
		if (p[node] == node) return node;
		return p[node] = find(p[node]);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[M][3];
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());

			a[i][0] = Integer.parseInt(stk.nextToken());
			a[i][1] = Integer.parseInt(stk.nextToken());
			a[i][2] = Integer.parseInt(stk.nextToken());
		}
	}
}
