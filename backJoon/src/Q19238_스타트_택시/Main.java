package Q19238_스타트_택시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int[][] a, g, c;
	private int N, M, O; // 맵 크기, 사람 수, 연료
	private int ans;
	private int[] curr_g, curr_c;
	private final int[] dr = {-1, 0, 1, 0};
	private final int[] dc = {0, -1, 0, 1};
	private final int cc = (int) 1e5;


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
		curr_g = g[M];
		for (int i = 0; i < M; i++) {
			if (!bfs_g()) {
				ans = -1;
				return;
			}

			if (!bfs_c()) {
				ans = -1;
				return;
			}
		}
		ans = O;
	}

	private boolean bfs_c() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[]{curr_c[0], curr_c[1], 0});
		boolean visited[][] = new boolean[N][N];

		visited[curr_c[0]][curr_c[1]] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == curr_g[0] && curr[1] == curr_g[1]) {
				O -= curr[2];
				if (O < 0) return false;

				O += curr[2] * 2;
				return true;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || a[nr][nc] == 1) {
					continue;
				}

				visited[nr][nc] = true;
				q.add(new int[]{nr, nc, curr[2] + 1});
			}
		}

		return false;
	}

	private boolean bfs_g() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[]{curr_g[0], curr_g[1], 0});
		boolean visited[][] = new boolean[N][N];

		visited[curr_g[0]][curr_g[1]] = true;
		int dist = Integer.MAX_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
			if (n1[0] == n2[0]) return n1[1] - n2[1];
			return n1[0] - n2[0];
		});

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (dist != Integer.MAX_VALUE && curr[2] > dist) {
				break;
			}

			if (a[curr[0]][curr[1]] >= cc) {
				if (dist == Integer.MAX_VALUE) {
					dist = curr[2];
				}
				pq.add(curr);
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || a[nr][nc] == 1) {
					continue;
				}

				visited[nr][nc] = true;
				q.add(new int[]{nr, nc, curr[2] + 1});
			}
		}

		if (!pq.isEmpty()) {
			O -= dist;
			if (O < 0) return false;

			int[] curr = pq.poll();
			int idx = a[curr[0]][curr[1]] - cc;
			curr_c = c[idx];
			curr_g = g[idx];
			a[curr[0]][curr[1]] = 0;
			return true;
		}

		return false;
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		O = Integer.parseInt(stk.nextToken());
		a = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		g = new int[M + 1][2];
		c = new int[M][2];
		stk = new StringTokenizer(br.readLine());
		g[M] = new int[]{Integer.parseInt(stk.nextToken()) - 1, Integer.parseInt(stk.nextToken()) - 1};
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(stk.nextToken()) - 1;
			int col = Integer.parseInt(stk.nextToken()) - 1;
			a[row][col] = i + cc;
			c[i] = new int[]{row, col};
			row = Integer.parseInt(stk.nextToken()) - 1;
			col = Integer.parseInt(stk.nextToken()) - 1;
			g[i] = new int[]{row, col};
		}
	}
}
