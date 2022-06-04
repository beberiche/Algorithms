package Q12026_BOJ거리;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] arr = new char[] { 0, 'B', 'O', 'J' };
	static char[] boj;
	static int[] dp;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		dp = new int[1000];
		boj = sc.next().toCharArray();
		Arrays.fill(dp, 987654321);
		dp[0] = 0;

		for (int i = 1; i < N; i++) {
			char curr = arr[i % 3 + 1];
			for (int j = i; j < N; j++) {
				if (boj[j] == curr) {
					dp[i] = Math.min(dp[j], (i - j) * (i - j));
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

}
