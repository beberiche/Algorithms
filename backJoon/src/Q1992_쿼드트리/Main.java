package Q1992_쿼드트리;

import java.util.Scanner;

public class Main {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		power(0, 0, N);
		System.out.println(sb.toString());
	}

	public static void power(int r, int c, int n) {
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (map[r][c] == map[i][j])
					continue;
				sb.append("(");

				n /= 2;
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						power(r + k * n, c + l * n, n);
					}
				}
				sb.append(")");
				return;
			}
		}

		sb.append(map[r][c]);
	}
}
