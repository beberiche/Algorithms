package Q10026_적록색약;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;
	static int total;
	static int totalRG;
	static char color;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		char[][] mapRG = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j];
				if (temp[j] == 'G')
					temp[j] = 'R';
				mapRG[i][j] = temp[j];
			}
		}

		// 일반인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					if (map[i][j] == 'R') {
						color = 'R';
					} else if (map[i][j] == 'G') {
						color = 'G';
					} else if (map[i][j] == 'B') {
						color = 'B';
					}
					DFS(i, j, map);
					total++;
				}
			}
		}

		visited = new boolean[N][N];
		// 적록색약
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					if (mapRG[i][j] == 'R') {
						color = 'R';
					} else if (mapRG[i][j] == 'B') {
						color = 'B';
					}
					DFS(i, j, mapRG);
					totalRG++;
				}
			}
		}

		System.out.println(total + " " + totalRG);
	}

	public static void DFS(int r, int c, char[][] map) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;

			if (map[nr][nc] != color)
				continue;

			if (visited[nr][nc])
				continue;

			visited[nr][nc] = true;
			DFS(nr, nc, map);
		}
	}
}
