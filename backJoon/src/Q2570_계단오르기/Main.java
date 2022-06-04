package Q2570_계단오르기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[10001];

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] dp = new int[10001];

		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
		dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);

		if (N >= 4) {
			for (int i = 4; i <= N; i++) {
				dp[i] = Math.max(dp[i - 2] + arr[i], arr[i - 1] + dp[i - 3] + arr[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
