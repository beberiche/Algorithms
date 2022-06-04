package Q1226_미로1_DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static boolean[][] visited;
	static int[][] maze;
	static int ans;

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

			ans = 0;
			visited[1][1] = true;
			DFS(1, 1);
			System.out.println("#" + T + " " + ans);
		}
	}

	public static void DFS(int r, int c) {
		if (maze[r][c] == 3) {
			ans = 1;
			return;
		}
		if (maze[r][c] == 1) {
			return;
		}

		if (!visited[r - 1][c]) {
			visited[r - 1][c] = true;
			DFS(r - 1, c);
		}
		if (!visited[r][c - 1]) {
			visited[r][c - 1] = true;
			DFS(r, c - 1);
		}
		if (!visited[r][c + 1]) {
			visited[r][c + 1] = true;
			DFS(r, c + 1);
		}
		if (!visited[r + 1][c]) {
			visited[r + 1][c] = true;
			DFS(r + 1, c);
		}
	}
}
