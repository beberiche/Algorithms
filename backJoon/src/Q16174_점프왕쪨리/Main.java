package Q16174_점프왕쪨리;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int r, c;
	int step;

	public Node(int r, int c, int step) {
		this.r = r;
		this.c = c;
		this.step = step;
	}
}

public class Main {
	static final int[] dr = { 0, 1 };
	static final int[] dc = { 1, 0 };
	static int[][] map;
	static int N;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		System.out.println(BFS(0, 0) ? "HaruHaru" : "Hing");
	}

	public static boolean BFS(int r, int c) {
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(r, c, map[r][c]));

		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (curr.r == N - 1 && curr.c == N - 1) {
				return true;
			}

			for (int d = 0; d < 2; d++) {
				int nr = curr.r + dr[d] * curr.step;
				int nc = curr.c + dc[d] * curr.step;

				if (isValid(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, map[nr][nc]));
				}
			}
		}
		return false;
	}

	public static boolean isValid(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
