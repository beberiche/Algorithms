package Q16926_배열돌리기1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		int Rcnt = Math.min(N, M) / 2;
		for (int r = 0; r < R; r++) {
			for (int i = 0; i < Rcnt; i++) {
				int y = i, x = i;
				int tmp = map[y][x];

				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];

					if (ny >= i && nx >= i && ny < N - i && nx < M - i) {
						map[y][x] = map[ny][nx];
						y = ny;
						x = nx;
						j -= 1;
					}
					continue;
				}
				map[i + 1][i] = tmp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
