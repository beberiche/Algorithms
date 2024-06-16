package Q12908_텔레포트_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int a[][];
	private long dist[][];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(dist[0][1]);
	}

	private void solve() {
		// r,c,cost
		dist = new long[8][8];
		long INF = (long) 1e9 * 4 + 4;
		for (int i = 0; i < 8; i++) {
			Arrays.fill(dist[i], INF);
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}

				// 텔포가 가능한 경우
				// 2->3 | 3->2 | 4->5 | 5->4 | 6->7 | 7->6
				if (check(i, j) && dist[i][j] > 10) {
					dist[i][j] = 10;
					dist[j][i] = 10;
					continue;
				}

				int d = Math.abs(a[i][0] - a[j][0]) + Math.abs(a[i][1] - a[j][1]);
				if (dist[i][j] > d) {
					dist[i][j] = d;
					dist[j][i] = d;
				}
			}
		}

		for (int k = 0; k < 8; k++) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
	}

	private boolean check(int i, int j) {
		return (i == 2 && j == 3) || (i == 4 && j == 5) || (i == 6 && j == 7);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = new int[8][];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		a[0] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
		stk = new StringTokenizer(br.readLine());
		a[1] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};

		int idx = 2;

		for (int i = 0; i < 3; i++) {
			stk = new StringTokenizer(br.readLine());
			a[idx++] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
			a[idx++] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
		}
	}
}
