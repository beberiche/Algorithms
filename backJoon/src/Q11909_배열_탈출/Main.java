package Q11909_배열_탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private int N, a[][], costs[][];
	private int ans;

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
		// cost,val,i,j
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
		pq.add(new int[]{0, a[0][0], 0, 0});
		costs[0][0] = 0;
		int[] dr = new int[]{0, 1};
		int[] dc = new int[]{1, 0};

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int cost = curr[0];
			int val = curr[1];
			int r = curr[2];
			int c = curr[3];

			if (r == N - 1 && c == N - 1) {
				ans = cost;
				break;
			}

			for (int d = 0; d < 2; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= N || nc >= N) continue;

				if (costs[nr][nc] > cost && val > a[nr][nc]) {
					costs[nr][nc] = cost;
					pq.add(new int[]{cost, a[nr][nc], nr, nc});
				}

				if(val <= a[nr][nc]) {
					int add = a[nr][nc] - val + 1;
					pq.add(new int[]{cost+add, val+add, r,c});
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		costs = new int[N][N];
		int INF = (int) 1e9;
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				costs[i][j] = INF;
			}
		}
	}
}

