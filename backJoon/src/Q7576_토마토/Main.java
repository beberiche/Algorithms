package Q7576_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int r;
	int c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int[] dr = new int[] { -1, 0, 1, 0 };
	static int[] dc = new int[] { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;
	static int R;
	static int C;
	static int day;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();

		map = new int[R][C];
		visited = new boolean[R][C];
		// 입력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1) {
					visited[i][j] = true;
					q.add(new int[] { i, j });
				}
			}
		}
		BFS();

		if (!isRipe()) {
			System.out.println(-1);
		} else {
			System.out.println(date());
		}
	}

	public static void BFS() {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];
			for (int i = 0; i < 4; i++) {
				int nr = currR + dr[i];
				int nc = currC + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;

				if (visited[nr][nc])
					continue;

				if (map[nr][nc] != 0)
					continue;

				visited[nr][nc] = true;
				map[nr][nc] = map[currR][currC] + 1;
				q.add(new int[] { nr, nc });

			}
		}
	}

	public static boolean isRipe() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static int date() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				day = Math.max(day, map[i][j]);
			}
		}
		if (day == 1) {
			return 0;
		} else {
			return day - 1;
		}
	}
}
