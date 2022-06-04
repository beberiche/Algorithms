package Q1949_등산로조성;

import java.util.Scanner;

public class Main {
	static int N; // 지도 한 변의 길이
	static int K; // 최대 공사 가능 깊이
	static int[][] map;
	static boolean[][] visited;
	static int st; // 등산로 시작
	static int maxDist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			st = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			maxDist = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					st = Math.max(st, map[i][j]);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == st) {
						visited[i][j] = true;
						DFS(i, j, 1, st, false);
						visited[i][j] = false;
					}
				}
			}
			System.out.println("#" + t + " " + maxDist);
		}
	}

	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	private static void DFS(int r, int c, int dist, int h, boolean cut) {

		maxDist = Math.max(maxDist, dist);
		for (int d = 0; d < 4; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;

			if (visited[nr][nc])
				continue;

			if (h <= map[nr][nc] && !cut) {
				for (int k = 1; k <= K; k++) {
					cut = true;
					map[nr][nc] -= k;
					if (h > map[nr][nc]) {
						visited[nr][nc] = true;
						DFS(nr, nc, dist + 1, map[nr][nc], cut);
						visited[nr][nc] = false;
					}
					map[nr][nc] += k;
					cut = false;
				}
			}

			if (h > map[nr][nc]) {
				visited[nr][nc] = true;
				DFS(nr, nc, dist + 1, map[nr][nc], cut);
				visited[nr][nc] = false;
			}
		}
	}
}
