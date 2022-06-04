package Q2747_피보나치수;

import java.util.Scanner;

public class Main {
	static final int INF = -100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = INF;
		}

		dp[1] = 1;

		fibo(N, dp);
		System.out.println(dp[N]);

	}

	static int fibo(int N, int[] dp) {
		if (dp[N] != INF) {
			return dp[N];
		}

		if (N == 1) {
			return 1;
		}

		return dp[N] = fibo(N - 1, dp) + fibo(N - 2, dp);
	}
}
