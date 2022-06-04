package Q2447_별찍기10;

import java.util.Scanner;

public class Main {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];

		solve(N, 0, 0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve(int n, int y, int x) {
		if (n == 1) {
			map[y][x] = 1;
			return;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					map[i][j] = 0;
				} else {
					int divN = n / 3;
					solve(divN, y + i * divN, x + j * divN);
				}
			}
		}
	}
}
