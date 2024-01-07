package Q21924_도시_건설;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	int N, M, edge[][], p[], cnt;
	long sum, ret;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(cnt == N - 1 ? sum - ret : -1);
	}


	private void solve() {
		Arrays.sort(edge, (n1, n2) -> n1[2] - n2[2]);

		for (int i = 0; i < M; i++) {
			int x1 = find(edge[i][0]);
			int x2 = find(edge[i][1]);

			if (x1 != x2) {
				union(x1, x2);
				ret += edge[i][2];
				cnt++;
			}

			if (cnt == N - 1) break;
		}
	}

	private void union(int n1, int n2) {
		if (n1 < n2) p[n2] = n1;
		else p[n1] = n2;
	}

	private int find(int n) {
		if (n == p[n]) return n;
		return p[n] = find(p[n]);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		edge = new int[M][3];
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			edge[i][0] = Integer.parseInt(stk.nextToken());
			edge[i][1] = Integer.parseInt(stk.nextToken());
			edge[i][2] = Integer.parseInt(stk.nextToken());
			sum += edge[i][2];
		}
	}
}
