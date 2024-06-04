package Q16985_Maaaaaaaaaze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int a[][][][], ans, INF = (int) 1e9;
	private int[] dr = {-1, 0, 1, 0, 0, 0};
	private int[] dc = {0, -1, 0, 1, 0, 0};
	private int[] dz = {0, 0, 0, 0, -1, 1};
	private boolean visited[];
	private List<Integer> list;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans == INF ? -1 : ans);
	}

	private void solve() {
		visited = new boolean[5];
		ans = INF;
		list = new ArrayList<>();
		comb(0);
	}

	private void comb(int idx) {
		if (idx >= 5) {
			go();
			return;
		}


		for (int i = 0; i < 5; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			list.add(i);
			comb(idx + 1);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}

	private void go() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					for (int l = 0; l < 4; l++) {
						for (int m = 0; m < 4; m++) {
							int[][][] curr_map = new int[5][5][5];
							curr_map[0] = a[list.get(0)][i];
							curr_map[1] = a[list.get(1)][j];
							curr_map[2] = a[list.get(2)][k];
							curr_map[3] = a[list.get(3)][l];
							curr_map[4] = a[list.get(4)][m];

							bfs(curr_map);
						}
					}
				}
			}
		}
	}

	private void bfs(int[][][] currMap) {
		if (currMap[0][0][0] == 0 || currMap[4][4][4] == 0) return;

		boolean[][][] visited = new boolean[5][5][5];
		visited[0][0][0] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0, 0, 0});

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (ans <= curr[3]) break;

			if (curr[0] == 4 && curr[1] == 4 && curr[2] == 4) {
				ans = curr[3];
				break;
			}

			for (int d = 0; d < 6; d++) {
				int nz = curr[0] + dz[d];
				int nr = curr[1] + dr[d];
				int nc = curr[2] + dc[d];
				if (nz < 0 || nz >= 5 || nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

				if (visited[nz][nr][nc] || currMap[nz][nr][nc] == 0) continue;

				visited[nz][nr][nc] = true;
				q.add(new int[]{nz, nr, nc, curr[3] + 1});
			}
		}
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = new int[5][4][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					a[i][0][j][k] = Integer.parseInt(stk.nextToken());
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int r = 1; r < 4; r++) {
				int[][] prev = a[i][r - 1];
				// 오른쪽 90도 회전.
				a[i][r] = rotate(prev);
			}
		}
	}


	private int[][] rotate(int[][] prev) {
		int[][] ret = new int[5][5];
		int idx1 = 0;
		int idx2 = 0;
		for (int i = 0; i < 5; i++) {
			idx2 = 0;
			for (int j = 4; j >= 0; j--) {
				ret[idx1][idx2++] = prev[j][i];
			}
			idx1++;
		}
		return ret;
	}
}