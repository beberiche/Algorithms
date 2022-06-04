package Q1226_미로1_BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
	int r;
	int c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] maze;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1226.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int T = 1; T <= 10; T++) {
			br.readLine();
			maze = new int[16][16];
			visited = new boolean[16][16];

			for (int i = 0; i < 16; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = temp[j] - '0';
				}
			}

			System.out.println("#" + T + " " + BFS(1, 1));

		}
	}

	public static int BFS(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c));
		visited[r][c] = true;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			int p1 = p.r;
			int p2 = p.c;

			for (int d = 0; d < 4; d++) {
				int nr = p1 + dr[d];
				int nc = p2 + dc[d];
				if (maze[nr][nc] == 3) {
					return 1;
				}

				if (!visited[nr][nc] && maze[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new Pos(nr, nc));
				}
			}
		}
		return 0;
	}
}
