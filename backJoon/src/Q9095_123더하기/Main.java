package Q9095_123더하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int t = 0; t < TC; t++) {
			int n = sc.nextInt();

			int[] dp = new int[n + 1];

			dp[1] = 1;
			if (n >= 2) {
				dp[2] = 2;
			}
			if (n >= 3) {
				dp[3] = 4;
			}
			if (n >= 4) {
				for (int i = 4; i <= n; i++) {
					dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
				}
			}
			System.out.println(dp[n]);
		}
	}
}
