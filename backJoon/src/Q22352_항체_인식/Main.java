package Q22352_항체_인식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, a[][], b[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new int[N][M];
		b = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				b[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		boolean check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] != b[i][j]) {
					if (check) {
						System.out.println("NO");
						return;
					} else {
						bfs(i, j);
						check = true;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i][j] != b[i][j]) {
					System.out.println("NO");
					return;
				}
			}
		}

		System.out.println("YES");
	}

	private static void bfs(int i, int j) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i, j});
		boolean visited[][] = new boolean[N][M];

		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		int prev = a[i][j];
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			visited[curr[0]][curr[1]] = true;
			a[curr[0]][curr[1]] = b[i][j];

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (visited[nr][nc] || a[nr][nc] != prev) continue;

				visited[nr][nc] = true;
				q.add(new int[]{nr, nc});
			}
		}
	}
}
