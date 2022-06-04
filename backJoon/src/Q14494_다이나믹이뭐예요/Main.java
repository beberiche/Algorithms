package Q14494_다이나믹이뭐예요;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		long[][] dp = new long[N + 1][M + 1];
		dp[1][1] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (i == 1 && j == 1)
					continue;
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % 1000000007;
			}
		}
		System.out.println(dp[N][M]);
	}
}
