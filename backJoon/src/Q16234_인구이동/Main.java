package Q16234_인구이동;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, L, R;
	static int[][] map;
	static final int[] dr = { 0, -1, 0, 1 };
	static final int[] dc = { -1, 0, 1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();

		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		int cnt = 0;
		while (true) {
			visited = new boolean[N][N];
			boolean flag = true;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int d = 0; d < 4; d++) {
						if (visited[r][c])
							continue;

						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;

						int diff = Math.abs(map[r][c] - map[nr][nc]);

						if (diff > R || diff < L)
							continue;

						if (visited[nr][nc])
							continue;

						BFS(r, c);
						flag = false;
					}
				}
			}
			if (flag)
				break;

			cnt++;
		}
		System.out.println(cnt);
	}

	public static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();

		visited[r][c] = true;
		q.add(new int[] { r, c });
		list.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			;
			for (int d = 0; d < 4; d++) {

				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				int diff = Math.abs(map[pos[0]][pos[1]] - map[nr][nc]);

				if (diff > R || diff < L)
					continue;

				if (visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
				list.add(new int[] { nr, nc });
			}
		}

		int sum = 0;
		for (int[] pos : list)
			sum += map[pos[0]][pos[1]];

		for (int[] pos : list)
			map[pos[0]][pos[1]] = sum / list.size();

	}
}
