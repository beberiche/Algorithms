package Q1249_보급로;

import java.util.PriorityQueue;
import java.util.Scanner;

class Pos implements Comparable<Pos> {
	int r, c;
	int time;

	public Pos(int r, int c, int time) {
		this.r = r;
		this.c = c;
		this.time = time;
	}

	@Override
	public int compareTo(Pos o) {
		// TODO Auto-generated method stub
		return this.time - o.time;
	}

}

public class Solution {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] temp;
	static boolean[][] visited;
	static int minTime;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char[] temp = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}

			minTime = INF;
			visited = new boolean[N][N];

			temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = INF;
				}
			}

			temp[0][0] = 0;

			BFS(0, 0, N - 1, N - 1, N);
			System.out.println("#" + t + " " + minTime);
		}
	}

	private static void BFS(int r, int c, int gR, int gC, int len) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();

		pq.add(new Pos(r, c, 0));
		visited[r][c] = true;

		while (!pq.isEmpty()) {
			Pos curr = pq.poll();

			if (curr.r == gR && curr.c == gC) {
				minTime = minTime < curr.time ? minTime : curr.time;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= len || nc >= len)
					continue;

				if (visited[nr][nc])
					continue;

				int sumTime = curr.time + map[nr][nc];

				if (sumTime > minTime)
					continue;

				if (sumTime > temp[nr][nc])
					continue;

				visited[nr][nc] = true;
				temp[nr][nc] = sumTime;
				pq.add(new Pos(nr, nc, sumTime));
			}
		}

	}
}
