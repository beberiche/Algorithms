package Q4189_장기2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] dr = new int[] { -2, -2, -1, 1, 2, 2, 1, -1 };
	static final int[] dc = new int[] { -1, 1, 2, 2, 1, -1, -2, -2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];

		int F = sc.nextInt();
		int C = sc.nextInt();
		int S = sc.nextInt();
		int K = sc.nextInt();
		map[F][C] = 1;
		map[S][K] = -1;

		int ans = 100000;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { F, C, 0 });
		visited[F][C] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0] == S && curr[1] == K) 
				ans = Math.min(ans, curr[2]);
			
			for (int i = 0; i < 8; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 1 || nc < 1 || nr > N || nc > M)
					continue;

				if (visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc, curr[2] + 1 });
			}
		}
		System.out.println(ans);
	}
	
}
