package Q11722_가장_긴_감소하는_부분수열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		int[] DP = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < N; i++) {
			DP[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && DP[j] + 1 > DP[i]) {
					DP[i] = DP[j] + 1;
				}
			}
			ans = Math.max(DP[i], ans);
		}
		System.out.println(ans);
	}
}
