package Q2613_토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] box = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				box[i][j] = sc.nextInt();
			}
		}

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (box[i][j] == 1) {
					q.add(new int[] { i, j, 1 });
				}
			}
		}

		int ans = 1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;

				if (box[nr][nc] != 0)
					continue;

				box[nr][nc] = curr[2] + 1;
				q.add(new int[] { nr, nc, box[nr][nc] });
				ans = box[nr][nc];
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(box[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(ans-1);
		
	}
}
