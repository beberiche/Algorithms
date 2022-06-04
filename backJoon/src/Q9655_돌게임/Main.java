package Q9655_돌게임;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] DP = new int[N + 1];

		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 1;

		for (int i = 4; i <= N; i++) {
			DP[i] = Math.min(DP[i - 1], DP[i - 3]) + 1;
		}

		System.out.println(DP[N] % 2 == 1 ? "SK" : "CY");
	}
}
