package Q1261_알고스팟;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[M][N];
		for (int i = 0; i < M; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j] - '0';
			}
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(((n1,n2)-> n1[2]-n2[2]));
		pq.add(new int[] { 0, 0, 0 });
		final int[] dr = { -1, 0, 1, 0 };
		final int[] dc = { 0, 1, 0, -1 };
		boolean[][] visited = new boolean[M][N];
		visited[0][0] = true;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (curr[0] == M - 1 && curr[1] == N - 1) {
				System.out.println(curr[2]);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= M || nc >= N) {
					continue;
				}

				if (visited[nr][nc]) {
					continue;
				}

				if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					pq.add(new int[] { nr, nc, curr[2] });
				}
				if (map[nr][nc] == 1) {
					visited[nr][nc] = true;
					pq.add(new int[] { nr, nc, curr[2] + 1 });
				}
			}
		}
	}
}
