package Q16932_모양_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M, a[][], aa[][], ans;
	private int dr[] = {-1, 0, 1, 0};
	private int dc[] = {0, -1, 0, 1};
	private boolean visited[][];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans+1);
	}

	private void solve() {
		visited = new boolean[N][M];
		aa = new int[N][M];
		int idx = 1;
		List<int[]> zeroList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] == 1 && !visited[i][j]) {
					go(i, j, idx);
					idx++;
				} else if (a[i][j] == 0) {
					zeroList.add(new int[]{i, j});
				}
			}
		}

		boolean visited2[] = new boolean[idx];
		Queue<Integer> used = new LinkedList<>();
		for (int i = 0; i < zeroList.size(); i++) {
			int ret = 0;

			for (int d = 0; d < 4; d++) {
				int nr = zeroList.get(i)[0] + dr[d];
				int nc = zeroList.get(i)[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited2[aa[nr][nc]]) continue;

				visited2[aa[nr][nc]] = true;
				used.add(aa[nr][nc]);
				ret += a[nr][nc];
			}

			while (!used.isEmpty()) {
				int curr = used.poll();
				visited2[curr] = false;
			}
			ans = Math.max(ans, ret);
		}
	}

	private void go(int r, int c, int idx) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> q2 = new LinkedList<>();
		q.add(new int[]{r, c});
		q2.add(new int[]{r, c});
		visited[r][c] = true;
		int ret = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			ret++;
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || a[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				q.add(new int[]{nr, nc});
				q2.add(new int[]{nr, nc});
			}
		}

		while (!q2.isEmpty()) {
			int[] curr = q2.poll();
			a[curr[0]][curr[1]] = ret;
			aa[curr[0]][curr[1]] = idx;
		}
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
