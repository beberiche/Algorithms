package Q1012_유기농배추;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int cure;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int M;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int T = 0; T < TC; T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 가로길이
			M = Integer.parseInt(st.nextToken());
			// 세로길이
			N = Integer.parseInt(st.nextToken());
			// 배추의 갯수
			int K = Integer.parseInt(st.nextToken());

			map = new int[M][N];
			visited = new boolean[M][N];
			cure = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						cure++;
					}
				}
			}
			System.out.println(cure);
		}

	}

	public static void DFS(int r, int c) {
		if (map[r][c] == 0) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= M || nc >= N)
				continue;

			if (visited[nr][nc])
				continue;

			if (map[nr][nc] == 0)
				continue;

			visited[nr][nc] = true;
			DFS(nr, nc);
		}
	}
}
