package Q1952_수영장;

import java.util.Scanner;

public class Solution2_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[] fees = new int[4];
			// [0] : 1일이용권
			// [1] : 1달이용권
			// [2] : 3달이용권
			// [3] : 12달이용권

			for (int i = 0; i < fees.length; i++)
				fees[i] = sc.nextInt();

			int[] monthes = new int[12];

			for (int i = 0; i < monthes.length; i++) {
				monthes[i] = sc.nextInt();
			}

			int[] DP = new int[13];

			DP[1] = Math.min(fees[0] * monthes[0], fees[1]);
			DP[2] = DP[1] + Math.min(fees[0] * monthes[1], fees[1]);
			for (int i = 3; i <= 12; i++) {
				DP[i] = Math.min((DP[i - 1] + Math.min(fees[0] * monthes[i - 1], fees[1])), DP[i - 3] + fees[2]);
			}
			System.out.println("#" + t + " " + Math.min(DP[12], fees[3]));
		}
	}
}
