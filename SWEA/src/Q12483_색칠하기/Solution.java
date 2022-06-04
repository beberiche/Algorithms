package Q12483_색칠하기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input12483.txt"));
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int T = 1; T <= TC; T++) {
			int[][] map = new int[10][10];
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				int r1 = sc.nextInt();
				int c1 = sc.nextInt();
				int r2 = sc.nextInt();
				int c2 = sc.nextInt();
				int col = sc.nextInt();

				for (int r = r1; r <= r2; r++) {
					for (int c = c1; c <= c2; c++) {
						map[r][c] += col;
					}
				}
			}

			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[i][j] == 3) {
						cnt++;
					}
				}
			}

			System.out.printf("#%d %d\n", T, cnt);
		}

	}
}
