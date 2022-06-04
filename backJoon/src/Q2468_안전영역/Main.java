package Q2468_안전영역;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] copyMap;
	static int N;
	static int cnt;
	static int max = Integer.MIN_VALUE;

	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 101; i++) {
			copyMapReset(i);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (copyMap[r][c] != -1 && copyMap[r][c] != 0) {
						DFS(r, c);
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);
	}

	public static void copyMapReset(int h) {
		copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= h) {
					copyMap[i][j] = -1;
				} else {
					copyMap[i][j] = map[i][j];
				}
			}
		}
		cnt = 0;
	}

	public static void DFS(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (copyMap[nr][nc] == -1)
				continue;
			if (copyMap[nr][nc] == 0) {
				continue;
			}
			copyMap[nr][nc] = 0;
			DFS(nr, nc);
		}
	}
}
