package Q20500_Ezreal_여눈부터_가네_ㅈㅈ;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if (N <= 2) {
			System.out.println(N == 1 ? 0 : 1);
			return;
		}
		int dp[][] = new int[N + 1][3];
		dp[2][0] = 1;
		dp[2][1] = 1;

		int DIV = (int) 1e9 + 7;
		for (int i = 3; i <= N; i++) {
			dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % DIV;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % DIV;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % DIV;
		}

		System.out.println(dp[N][0]);
	}

}
