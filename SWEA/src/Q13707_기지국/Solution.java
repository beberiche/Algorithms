package Q13707_기지국;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	static String[][] map;
	static int N;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input13707.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());

			map = new String[N][N];
			for (int i = 0; i < N; i++) {
				String[] arr = br.readLine().toString().split("");
				map[i] = arr;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("A")) {
						solve(1, i, j);
					}
					if (map[i][j].equals("B")) {
						solve(2, i, j);
					}
					if (map[i][j].equals("C")) {
						solve(3, i, j);
					}
				}
			}

			int homeCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].equals("H")) {
						homeCnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", t, homeCnt);
		}
	}

	private static void solve(int r, int i, int j) {
		for (int k = 1; k <= r; k++) {
			for (int d = 0; d < 4; d++) {
				int ay = i + dy[d] * k;
				int ax = j + dx[d] * k;
				if (ay >= 0 && ax >= 0 && ay < N && ax < N) {
					if (map[ay][ax].equals("H")) {
						map[ay][ax] = "X";
					}
				}
			}
		}
	}
}
