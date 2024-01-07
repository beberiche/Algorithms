package Q14852_타일_채우기_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long dp1[] = new long[N + 1];
		long dp2[] = new long[N + 1];

		dp1[1] = 2;
		if (N == 1) {
			System.out.println(2);
			return;
		}
		dp1[2] = 7;
		dp2[2] = 1;

		long DIV = (int) 1e9 + 7;

		for (int i = 3; i <= N; i++) {
			dp2[i] = (dp1[i - 3] + dp2[i - 1]) % DIV;
			dp1[i] = (dp1[i - 1] * 2 + dp1[i - 2] * 3 + dp2[i]*2) % DIV;
		}

		System.out.println(dp1[N] % DIV);
	}
}
