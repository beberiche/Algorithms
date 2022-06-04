package Q9461_파도반수열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= 100; i++)
			dp[i] = dp[i - 3] + dp[i - 2];

		while (--T >= 0)
			System.out.println(dp[sc.nextInt()]);

	}
}
