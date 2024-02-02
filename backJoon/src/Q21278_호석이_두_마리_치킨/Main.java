package Q21278_호석이_두_마리_치킨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int N, M, dist[][], INF = (int) 1e9;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		int st = 1, ed = 1, min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int sum = 0;
				for (int k = 1; k <= N; k++) {
					if (k != i && k != j) {
						sum += Math.min(dist[k][i], dist[k][j]);
					}
				}
				sum *= 2;
				if (min > sum) {
					st = i;
					ed = j;
					min = sum;
				}
			}
		}
		System.out.println(st + " " + ed + " " + min);
	}

	private void solve() {
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						dist[j][i] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			dist[n1][n2] = 1;
			dist[n2][n1] = 1;
		}
	}
}
