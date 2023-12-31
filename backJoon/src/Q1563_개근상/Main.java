package Q1563_개근상;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, dp[][][], MOD = (int) 1e6;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		dp = new int[N][3][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int ans = go(0, 0, 0);
		System.out.println(ans);
	}


	private static int go(int d, int l, int a) {
		if (l >= 2 || a >= 3) {
			return 0;
		}

		if (d >= N) {
			return 1;
		}

		if (dp[d][l][a] != -1) {
			return dp[d][l][a];
		}

		dp[d][l][a] = 0;
		dp[d][l][a] = go(d + 1, l, 0) + go(d + 1, l + 1, 0) + go(d + 1, l, a + 1);
		return dp[d][l][a] %= MOD;
	}
}
