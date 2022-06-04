package Q9625_BABBA;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ans = solve(0, N, "A");
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] solve(int cnt, int N, String str) {
		if (cnt == N) {
			char[] temp = str.toCharArray();
			int a = 0, b = 0;
			for (char t : temp) {
				if (t == 'A') {
					a++;
				} else {
					b++;
				}
			}
			return new int[] { a, b };
		}

		char[] temp = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char t : temp)
			sb.append(t == 'A' ? "B" : "BA");
		return solve(cnt + 1, N, sb.toString());
	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[][] dp = new int[N + 1][2];
//		dp[0][0] = 1;
//		dp[1][1] = 1;
//
//		for (int i = 2; i <= N; i++)
//			for (int n = 0; n < 2; n++)
//				dp[i][n] = dp[i - 2][n] + dp[i - 1][n];
//
//		System.out.println(dp[N][0] + " " + dp[N][1]);
//	}
}
