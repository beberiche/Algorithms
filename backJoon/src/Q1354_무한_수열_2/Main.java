package Q1354_무한_수열_2;

import java.util.Scanner;

public class Main {
	private static long N, dp[];
	private static int P, Q, X, Y, MAX;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		P = sc.nextInt();
		Q = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();

		MAX = (int)1e7;

		dp = new long[MAX + 1];
		dp[0] = 1;
		for (int i = 1; i <= MAX; i++) {
			int nx = i / P - X;
			int ny = i / Q - Y;

			if (nx <= 0) dp[i]++;
			else dp[i] += dp[nx];

			if (ny <= 0) dp[i]++;
			else dp[i] += dp[ny];
		}

		if (N <= MAX) {
			System.out.println(dp[(int) N]);
		} else {
			System.out.println(go(N));
		}
	}

	private static long go(long n) {
		if (n <= 0) return 1;

		if (n <= MAX) {
			return dp[(int) n];
		}

		return go(n / P - X) + go(n / Q - Y);
	}
}
