package Q2573_빙산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dr = { 0, -1, 0, 1 };
	static final int[] dc = { -1, 0, 1, 0 };
	static boolean[][] visited;
	static int[][] map;
	static int N, M, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			visited = new boolean[N][M];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						BFS(i, j);
						cnt++;
						if (cnt >= 2) {
							System.out.println(ans);
							return;
						}
					}
				}
			}
			if (cnt == 0) {
				System.out.println(0);
				return;
			}
			ans++;
		}

	}

	private static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		q.add(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (visited[nr][nc])
					continue;

				if (map[nr][nc] <= 0) {
					map[curr[0]][curr[1]] -= 1;
					continue;
				}
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}
	}
}
