package Q1309_동물원;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] dp = new int[100001][3];

		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for (int n = 2; n <= N; n++) {
			dp[n][0] = (dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901;
			dp[n][1] = (dp[n - 1][0] + dp[n - 1][2]) % 9901;
			dp[n][2] = (dp[n - 1][0] + dp[n - 1][1]) % 9901;
		}

		if (N == 0) {
			System.out.println(1);
		} else {
			System.out.println((dp[N][0] + dp[N][1] + dp[N][2])%9901 );
		}
	}
}
