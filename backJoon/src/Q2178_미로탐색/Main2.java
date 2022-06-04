package Q2178_미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int[][] maze;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static boolean[][] visited;
	static int dist = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char temp[] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j] = temp[j] - '0';
			}
		}

		maze[N - 1][M - 1] = 2;

		BFS(0, 0, 1);
	}

	public static void BFS(int r, int c, int d) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, d });
		maze[r][c] = -1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (maze[nr][nc] == -1 || maze[nr][nc] == 0) {
					continue;
				}
				if (maze[nr][nc] == 2) {
					System.out.println(curr[2] + 1);
					System.exit(0);
				}

				maze[nr][nc] = -1;
				q.add(new int[] { nr, nc, curr[2] + 1 });
			}
		}
	}
}