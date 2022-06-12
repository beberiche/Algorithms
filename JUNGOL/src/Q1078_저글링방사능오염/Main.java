package Q1078_저글링방사능오염;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] dr = new int[] { -1, 0, 1, 0 };
	static final int[] dc = new int[] { 0, 1, 0, -1 };

	static boolean[][] visited;

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

		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;

		int ans = 0;

		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[M][N];
		visited[y][x] = true;
		map[y][x] += 2;
		q.add(new int[] { y, x, map[y][x] });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			ans = Math.max(ans, curr[2]);
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;

				if (map[nr][nc] != 1 || map[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				map[nr][nc] = curr[2] + 1;
				q.add(new int[] { nr, nc, map[nr][nc] });
			}
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
				}
			}
		}

		System.out.printf("%d\n%d",ans,cnt);

	}
}
