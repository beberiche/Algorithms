package Q1462_보물섬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, -1, 0, 1 };
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Y = sc.nextInt();
		int X = sc.nextInt();

		map = new char[Y][X];

		for (int i = 0; i < Y; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < X; j++) {
				map[i][j] = temp[j];
			}
		}

		int max = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (map[i][j] == 'L') {
					max = Math.max(max, BFS(i, j, Y, X));
				}
			}
		}
		System.out.println(max);
	}

	private static int BFS(int i, int j, int Y, int X) {
		// TODO Auto-generated method stub
		int max = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[Y][X];
		visited[i][j] = true;
		q.add(new int[] { i, j, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			max = Math.max(max, curr[2]);
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= Y || nc >= X)
					continue;

				if (map[nr][nc] == 'W')
					continue;

				if (visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc, curr[2] + 1 });
			}
		}

		return max;
	}
}
