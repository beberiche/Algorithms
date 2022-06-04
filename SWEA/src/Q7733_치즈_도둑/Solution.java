package Q7733_치즈_도둑;

import java.util.Scanner;

public class Solution {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;
	static int ans; // 날마다 바뀌느느 치즈 조각의 수 가운데 최댓값
	static int total; // 날마다 바뀌는 치즈의 조각 수
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int TC = 1; TC <= T; TC++) {
			N = sc.nextInt();
			// 초기 치즈 역시 분리된 조각으로 보자면 1조각이다.
			// 따라서 1부터 시작
			ans = 1;
			// 케이스마다 리셋
			total = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			int max = 0; // 제일 높은 수
			int min = 101; // 제일 낮은수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(map[i][j], max);
					min = Math.min(map[i][j], min);
				}
			}

			// 요정이 먹는다.
			for (int i = min; i <= max; i++) {
				total = 0;
				visited = new boolean[N][N];
				// 먹은 부분을 -1로 바꾸자.
				eat(i);
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						// 먹은 부분 그리고 방문했던 부분을 제외하고
						// 모두 DFS
						if (!visited[j][k] && map[j][k] != -1) {
							DFS(j, k);
							total++;
						}
					}
					ans = Math.max(ans, total);
				}
			}
			System.out.println("#" + TC + " " + ans);
		}
	}

	public static void DFS(int r, int c) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 범위가 넘으면 out
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;

			// 요정이 먹은 부분이면 out
			if (map[nr][nc] == -1)
				continue;

			// 방문한 곳이면 out
			if (visited[nr][nc])
				continue;

			DFS(nr, nc);
		}
	}

	public static void eat(int day) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == day) {
					map[i][j] = -1;
				}
			}
		}
	}
}
