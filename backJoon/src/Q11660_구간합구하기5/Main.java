package Q11660_구간합구하기5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = sc.nextInt();

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = map[i][j - 1] + sc.nextInt();
			}
		}
		StringBuilder sb = new StringBuilder();
		while (--cnt >= 0) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int ans = 0;
			for (int i = x1; i <= x2; i++) {
				ans += map[i][y2] - map[i][y1 - 1];
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
