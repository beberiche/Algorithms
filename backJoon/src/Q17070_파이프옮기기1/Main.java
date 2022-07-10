package Q17070_파이프옮기기1;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		DFS(new int[] { 0, 1 }, 1);
		System.out.println(ans);		
	}

	private static void DFS(int[] point, int dir) {
		if (point[0] == N - 1 && point[1] == N - 1) {
			ans++;
			return;
		}

		int nr = point[0] + 1;
		int nc = point[1] + 1;

		if (dir == 1 && nc < N && map[point[0]][nc] == 0) {
			DFS(new int[] { point[0], nc }, 1);
		}

		if (dir == 1 && nr < N && nc < N && map[point[0]][nc] == 0 && map[nr][point[1]] == 0
				&& map[nr][nc] == 0) {
			DFS(new int[] { nr, nc }, 3);
		}

		if (dir == 2 && nr < N && map[nr][point[1]] == 0) {
			DFS(new int[] { nr, point[1] }, 2);
		}

		if (dir == 2 && nr < N && nc < N && map[point[0]][nc] == 0 && map[nr][point[1]] == 0
				&& map[nr][nc] == 0) {
			DFS(new int[] { nr, nc }, 3);
		}

		if (dir == 3 && nc < N && map[point[0]][nc] == 0) {
			DFS(new int[] { point[0], nc }, 1);
		}

		if (dir == 3 && nr < N && map[nr][point[1]] == 0) {
			DFS(new int[] { nr, point[1] }, 2);
		}

		if (dir == 3 && nr < N && nc < N && map[point[0]][nc] == 0 && map[nr][point[1]] == 0
				&& map[nr][nc] == 0) {
			DFS(new int[] { nr, nc }, 3);
		}
	}
}
