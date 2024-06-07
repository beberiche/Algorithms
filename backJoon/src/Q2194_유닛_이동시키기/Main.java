package Q2194_유닛_이동시키기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int N, M, A, B, K, a[][], st[], ed[], ans;

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
		//  r,c,이동 거리
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{st[0], st[1], 0});
		boolean visited[][] = new boolean[N][M];
		visited[st[0]][st[1]] = true;

		int[] dr = new int[]{-1, 0, 1, 0};
		int[] dc = new int[]{0, -1, 0, 1};

		ans = -1;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0] == ed[0] && curr[1] == ed[1]) {
				ans = curr[2];
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				// 기준 좌표 확인
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || a[nr][nc] == 1)
					continue;

				if (rangeCheck(d, nr, nc)) {
					visited[nr][nc] = true;
					q.add(new int[]{nr, nc, curr[2] + 1});
				}
			}
		}
	}

	private boolean rangeCheck(int d, int nr, int nc) {
		boolean check = true;

		// 범위 좌표 확인
		if (d == 0) {
			for (int r = 1; r < B; r++) {
				int ncc = nc + r;
				if (ncc >= M || a[nr][ncc] == 1) {
					check = false;
					break;
				}
			}
		} else if (d == 1) {
			for (int r = 1; r < A; r++) {
				int nrr = nr + r;
				if (nrr >= N || a[nrr][nc] == 1) {
					check = false;
					break;
				}
			}
		} else if (d == 2) {
			int nrr = nr + A - 1;
			if (nrr >= N || a[nrr][nc] == 1) {
				check = false;
			}

			if (check) {
				for (int r = 1; r < B; r++) {
					int ncc = nc + r;
					if (ncc >= M || a[nrr][ncc] == 1) {
						check = false;
						break;
					}
				}
			}
		} else {
			int ncc = nc + B - 1;
			if (ncc >= M || a[nr][ncc] == 1) {
				check = false;
			}

			if (check) {
				for (int r = 1; r < A; r++) {
					int nrr = nr + r;
					if (nrr >= N || a[nrr][ncc] == 1) {
						check = false;
						break;
					}
				}
			}
		}

		return check;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		a = new int[N][M];
		for (int i = 0; i < K; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken()) - 1;
			int n2 = Integer.parseInt(stk.nextToken()) - 1;
			a[n1][n2] = 1;
		}

		stk = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(stk.nextToken());
		int n2 = Integer.parseInt(stk.nextToken());
		st = new int[]{n1 - 1, n2 - 1};

		stk = new StringTokenizer(br.readLine());
		n1 = Integer.parseInt(stk.nextToken());
		n2 = Integer.parseInt(stk.nextToken());
		ed = new int[]{n1 - 1, n2 - 1};
	}
}
