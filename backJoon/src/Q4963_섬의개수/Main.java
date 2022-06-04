package Q4963_섬의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	static int R;
	static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			if (R == 0 && C == 0) {
				break;
			}

			map = new int[R][C];
			visited = new boolean[R][C];
			ans = 0;

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						DFS(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}

	}

	public static void DFS(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;

			if (map[nr][nc] == 0)
				continue;

			if (visited[nr][nc])
				continue;

			DFS(nr, nc);
		}
	}
}
