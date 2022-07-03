package Q13302_리조트;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 총 방학 일수
		int M = sc.nextInt(); // 리조트에 못가는 날

		int[][] DP = new int[N + 1][41];
		boolean[] holiday = new boolean[N + 1];
		final int INF = 987654321;
		
		for (int i = 0; i < M; i++)
			holiday[sc.nextInt()] = true;

		for (int i = 0; i < N + 1; i++) 
			for (int j = 0; j < 41; j++) 
				DP[i][j] = INF;
		

		DP[0][0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 41; j++) {
				if (DP[i][j] == INF)
					continue;

				if (holiday[i + 1])
					DP[i + 1][j] = Math.min(DP[i][j], DP[i + 1][j]);

				if (j >= 3)
					DP[i + 1][j - 3] = Math.min(DP[i][j], DP[i + 1][j - 3]);

				DP[i + 1][j] = Math.min(DP[i][j] + 10000, DP[i + 1][j]);
				if (i <= N - 3)
					DP[i + 3][j + 1] = Math.min(DP[i][j] + 25000, DP[i + 3][j + 1]);
				if (i <= N - 5)
					DP[i + 5][j + 2] = Math.min(DP[i][j] + 37000, DP[i + 5][j + 2]);

			}
		}
		int ans = INF;
		for (int j = 0; j < 41; j++) 
			ans = Math.min(ans, DP[N][j]);
		
		System.out.println(ans);
	}
}
