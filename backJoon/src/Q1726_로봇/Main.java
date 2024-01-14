package Q1726_로봇;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int N, M, a[][], st[], ed[], ans;

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
		// r,c,dir,dist
		Queue<int[]> q = new LinkedList<>();
		boolean visited[][][] = new boolean[N + 1][M + 1][5];

		// 동 서 남 북
		int[] dr = {0, 0, 0, 1, -1};
		int[] dc = {0, 1, -1, 0, 0};

		visited[st[0]][st[1]][st[2]] = true;
		q.add(new int[]{st[0], st[1], st[2], 0});

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == ed[0] && curr[1] == ed[1] && curr[2] == ed[2]) {
				ans = curr[3];
				q.clear();
				break;
			}

			// 전진
			int nr = curr[0];
			int nc = curr[1];

			for (int d = 1; d <= 3; d++) {
				nr += dr[curr[2]];
				nc += dc[curr[2]];

				if (nr >= 1 && nc >= 1 && nr <= N && nc <= M && !visited[nr][nc][curr[2]]) {
					if (a[nr][nc] == 0) {
						visited[nr][nc][curr[2]] = true;
						q.add(new int[]{nr, nc, curr[2], curr[3] + 1});
					} else {
						break;
					}
				}
			}

			// 좌측 회전
			// 동 북 서 남 -> 1 4 2 3
			int next_dir = curr[2] == 1 ? 4 : curr[2] == 4 ? 2 : curr[2] == 2 ? 3 : 1;
			if (!visited[curr[0]][curr[1]][next_dir]) {
				visited[curr[0]][curr[1]][next_dir] = true;
				q.add(new int[]{curr[0], curr[1], next_dir, curr[3] + 1});
			}
			// 우측 회전
			// 동 남 서 북
			next_dir = curr[2] == 1 ? 3 : curr[2] == 3 ? 2 : curr[2] == 2 ? 4 : 1;
			if (!visited[curr[0]][curr[1]][next_dir]) {
				visited[curr[0]][curr[1]][next_dir] = true;
				q.add(new int[]{curr[0], curr[1], next_dir, curr[3] + 1});
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		a = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		stk = new StringTokenizer(br.readLine());
		st = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
				Integer.parseInt(stk.nextToken())};

		stk = new StringTokenizer(br.readLine());
		ed = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
				Integer.parseInt(stk.nextToken())};
	}
}
