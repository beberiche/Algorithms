package Q5582_공통부분문자열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr1 = sc.next().toCharArray();
		char[] arr2 = sc.next().toCharArray();

		int dp[][] = new int[arr1.length+1][arr2.length+1];
		int max= 0;
		for (int i = 1; i <= arr1.length; i++) {
			for (int j = 1; j <= arr2.length; j++) {
				if (arr1[i-1] == arr2[j-1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		System.out.println(max);
	}
}
