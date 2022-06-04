package Q2839_설탕배달;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int INF = 50000;
	static boolean check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		Arrays.fill(dp, INF);

		if (N == 4 || N == 7) {
			System.out.println(-1);
			return;
		} else if (N == 3) {
			System.out.println(1);
			return;
		} else if (N >= 5) {
			dp[3] = 1;
			dp[5] = 1;

			for (int j = 6; j <= N; j++) {
				dp[j] = Math.min(dp[j - 3] + 1, dp[j - 5] + 1);
			}
		}

		System.out.println(dp[N] >= INF ? -1 : dp[N]);

	}

}
