package Q17836_공주님을_구해라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	int N, M, T, a[][], ans = -1;
	boolean visited[][][];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve(1, 1);
		m.output();
	}

	private void output() {
		System.out.println(ans == -1 ? "Fail" : ans);
	}

	private void solve(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		// r,c,시간,"그람" 소지 상태
		q.add(new int[]{r, c, 0, 0});

		visited = new boolean[N + 1][M + 1][2];
		visited[r][c][0] = true;

		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[2] > T) {
				q.clear();
				break;
			}

			if (curr[0] == N && curr[1] == M) {
				ans = curr[2];
				q.clear();
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 1 || nc < 1 || nr > N || nc > M || visited[nr][nc][curr[3]]) continue;

				if (curr[3] == 0 && a[nr][nc] == 1) continue;

				visited[nr][nc][curr[3]] = true;
				q.add(new int[]{nr, nc, curr[2] + 1, a[nr][nc] == 2 ? 1 : curr[3]});
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		T = Integer.parseInt(stk.nextToken());

		a = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		br.close();
	}
}
