package Q1455_뒤집기2;

import java.util.Scanner;

public class Main {
	static int[][] coin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		coin = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < M; j++) {
				coin[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int ans = 0;
		for (int r = N - 1; r >= 0; r--) {
			for (int c = M - 1; c >= 0; c--) {
				if (coin[r][c] == 1) {
					reverse(r, c);
					ans++;
				}
			}
		}

		System.out.println(ans);
	}

	private static void reverse(int r, int c) {
		for (int i = 0; i <= r; i++) {
			for (int j = 0; j <= c; j++) {
				coin[i][j] = 1 - coin[i][j];
			}
		}
	}

}
