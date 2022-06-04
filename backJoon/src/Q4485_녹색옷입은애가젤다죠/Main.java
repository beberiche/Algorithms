package Q4485_녹색옷입은애가젤다죠;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[][] copyMap;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = 1;
		while (true) {
			try {
				N = sc.nextInt();
				map = new int[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						map[i][j] = sc.nextInt();
					}
				}
				ans = 0;
				BFS(0, 0);
			} catch (Exception e) {
				break;
			}
			System.out.println("Problem " + tc + ": " + ans);
			tc++;
		}
	}

	public static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[i][j] = Integer.MAX_VALUE;
			}
		}

		q.add(new int[] { r, c });
		copyMap[0][0] = map[0][0];

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == N - 1 && curr[1] == N - 1) {
				ans = copyMap[N - 1][N - 1];
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				if (copyMap[nr][nc] > copyMap[curr[0]][curr[1]] + map[nr][nc]) {
					copyMap[nr][nc] = copyMap[curr[0]][curr[1]] + map[nr][nc];
					q.add(new int[] { nr, nc });
				}
			}
		}
	}
}
