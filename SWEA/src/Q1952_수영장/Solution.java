package Q1952_수영장;

import java.util.Scanner;

public class Solution {
	static int[] fees, monthes;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			fees = new int[4]; // 1년, 3달, 1달, 1일
			monthes = new int[12]; // 12개월
			for (int i = 0; i < 4; i++) {
				fees[i] = sc.nextInt();
			}

			for (int i = 0; i < 12; i++) {
				monthes[i] = sc.nextInt();
			}

			ans = Integer.MAX_VALUE;

			recur(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}

	public static void recur(int idx, int fee) {
		if (idx >= 12) {
			ans = Math.min(ans, fee);
			return;
		}
		if (ans < fee)
			return;

		recur(idx + 1, fees[3]); // 1년치 산 경우
		recur(idx + 3, fee + fees[2]); // 3개월 짜리 산 경우
		recur(idx + 1, fee + fees[1]); // 1개월 짜리 산 경우
		recur(idx + 1, fee + monthes[idx] * fees[0]); // 하루 짜리로 산 경우
	}
}
