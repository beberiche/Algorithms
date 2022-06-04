package Q2293_동전1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전의 갯수
		int K = sc.nextInt(); // 주어진 합

		int[] coin = new int[N + 1];
		int[] dp = new int[100001]; // 최댓값 100000이므로, 이 이상 크게 나오지 않는다. 또한 index 에러도 처리가 된다.

		for (int i = 1; i <= N; i++)
			coin[i] = sc.nextInt();

		// n1원은 dp[n1] 부터 해당 동전을 세는 카운트가 가능해진다.
		// n1보다 작은 합은 구할 수 없다.
		// dp[n1]이 n1을 나타내는 방법은 1개 뿐이다.
		// dp[n1-coin[n1]] 은 결국 dp[0] 이므로
		// dp[0] 이 1이면 모든 dp[n1]은 1부터 시작하는 것이 가능하다.

		dp[0] = 1;

		Arrays.sort(coin);
		// 제한시간 및 메모리 제한을 피하기 위한 바텀업
		// 작은 동전에에서 부터 누적되는 경우의 수를 더해간다면
		// 제일 큰 동전까지 사용하여 누적된 경우의 수가 dp[K]의 값이 될 거다.
		for (int i = 1; i <= N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}

		System.out.println(dp[K]);

	}

}