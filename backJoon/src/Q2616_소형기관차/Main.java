package Q2616_소형기관차;

import java.util.Scanner;

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();

		int[] dp1 = new int[N + 1]; // 소형기관차1
		int[] dp2 = new int[N + 1]; // 소형기관차2
		int[] dp3 = new int[N + 1]; // 소형기관차3

		int M = sc.nextInt();

		// 소형 기관차 1 부터 시작!
		dp1[M] = DPInit(M);
		for (int i = M + 1; i <= N; i++) {
			dp1[i] = Math.max(dp1[i - 1], FOR(i, M));
		}

		// 소형 기관차 2
		dp2[2 * M] = DPInit(2 * M);
		for (int i = 2 * M + 1; i <= N; i++) {
			dp2[i] = Math.max(dp2[i - 1], dp1[i - M] + FOR(i, M));
		}

		// 소형 기관차3
		dp3[3 * M] = DPInit(3 * M);
		for (int i = 3 * M + 1; i <= N; i++) {
			dp3[i] = Math.max(dp3[i - 1], dp2[i - M] + FOR(i, M));
		}

		System.out.println(dp3[N]);
	}

	public static int DPInit(int m) {
		int sum = 0;
		for (int i = 1; i <= m; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static int FOR(int idx, int m) {
		int sum = 0;
		for (int i = idx; i > idx - m; i--) {
			sum += arr[i];
		}
		return sum;
	}
}
