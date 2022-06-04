package Q13699_점화식;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long[] dp = new long[N + 1];

		dp[0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += (dp[j] * dp[i - j - 1]);
			}
		}

		System.out.println(dp[N]);
	}
}
