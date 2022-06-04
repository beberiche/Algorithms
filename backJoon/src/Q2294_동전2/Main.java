package Q2294_동전2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 갯수
		int K = sc.nextInt(); // 주어진 합

		int[] coin = new int[N + 1];
		int[] dp = new int[K + 1];
		int INF = 100001; // 절대 도달하지 못하는 수, 0혹은 0 이하의 값은 도달하지 못하는 경우이므로 min 값에서 배제 시키자
		for (int i = 1; i <= N; i++)
			coin[i] = sc.nextInt();

		for (int i = 1; i <= K; i++)
			dp[i] = INF;

		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}

		System.out.println(dp[K] == INF ? -1 : dp[K]);
	}

//	static int recur(int[] coin, int[] dp, int N, int INF, int K) {
//		if (K == 0) {
//			return 0;
//		}
//		if (K < 0) {
//			return 1000000;
//		}
//
//		if (dp[K] != INF) {
//			return dp[K];
//		}
//
//		dp[K] = 1000000;
//		for (int i = 0; i < N; i++) {
//			dp[K] = Math.min(dp[K], recur(coin, dp, N, INF, K - coin[i]) + 1);
//		}
//		return dp[K];
//	}
}
