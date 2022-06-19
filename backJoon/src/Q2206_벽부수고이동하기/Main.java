package Q2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static int N, M, ans;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		ans = 987654321;
		boolean[][] visited = new boolean[N][M];
		BFS(0, 0, 1, false, visited);

		if (ans == 987654321) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	public static void BFS(int r, int c, int dist, boolean crush, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();

		visited[r][c] = true;
		q.add(new int[] { r, c, dist });

		while (!q.isEmpty()) {
			int curr[] = q.poll();

			if (ans <= curr[2])
				break;

			if (curr[0] == N - 1 && curr[1] == M - 1)
				ans = curr[2];

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (visited[nr][nc])
					continue;

				if (map[nr][nc] == 1 && !crush) {
					map[nr][nc] = 0;
					BFS(nr, nc, curr[2] + 1, true, visited);
					map[nr][nc] = 1;
					visited[nr][nc] = false;
				} 
				if (map[nr][nc]==1) {
					continue;
				}

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc, curr[2] + 1 });
			}
		}
	}
}
