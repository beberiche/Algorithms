package Q17218_비밀번호_만들기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();

		int dp[][] = new int[A.length() + 1][B.length() + 1];

		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int i = A.length();
		int j = B.length();
		StringBuilder sb = new StringBuilder();
		while (dp[i][j] > 0) {
			if (dp[i - 1][j] == dp[i][j]) {
				i--;
			} else if (dp[i][j - 1] == dp[i][j]) {
				j--;
			} else {
				sb.append(A.charAt(i - 1));
				i--;
				j--;
			}
		}
		System.out.println(sb.reverse().toString());
	}
}
