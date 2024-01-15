package Q1245_농장_관리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int N, M, a[][], ans;
	private int[] dr = {-1, -1, 1, 1, 0, 0, 1, -1};
	private int[] dc = {-1, 1, -1, 1, 1, -1, 0, 0};
	private boolean visited[][];
	private Queue<int[]> q;

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
		visited = new boolean[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && bfs(i, j)) {
					ans++;
				}
			}
		}
	}

	private boolean bfs(int i, int j) {
		q.add(new int[]{i, j});
		visited[i][j] = true;
		boolean check = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int d = 0; d < dr.length; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

				if (a[nr][nc] > a[i][j]) {
					check = false;
				}

				if (visited[nr][nc] || a[nr][nc] != a[i][j]) continue;

				visited[nr][nc] = true;
				q.add(new int[]{nr, nc});
			}
		}
		return check;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[N][M];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}
