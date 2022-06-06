package Q1997_떡먹는호랑이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int D = sc.nextInt(); // 떡준 날
		int K = sc.nextInt(); // 떡의 갯수

		String[] dp = new String[D + 1];
		dp[1] = "A";
		dp[2] = "B";

		for (int i = 3; i <= D; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int cntA = 0;
		int cntB = 0;
		for (int i = 0; i < dp[D].length(); i++) {
			if (dp[D].charAt(i) == 'A') {
				cntA++;
			} else {
				cntB++;
			}
		}
		int A = 1;
		int num = K;
		while (true) {
			int temp = num - (A * cntA);
			if(temp%cntB == 0) {
				System.out.println(A);
				System.out.println(temp/cntB);
				break;
			}
			A++;
		}

	}
}
