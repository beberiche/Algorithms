package Q1486_장훈이의_높은_선반;

import java.util.Scanner;

public class Solution {
	static int employee[];
	static boolean visited[];
	static int N; // 점원의 수
	static int B; // 탑의 높이
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			B = sc.nextInt();

			// 입력
			employee = new int[N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++)
				employee[i] = sc.nextInt();

			ans = Integer.MAX_VALUE;
			powerSet(0, 0);
			System.out.println("#" + t + " " + (ans - B));
		}
	}

	public static void powerSet(int idx, int sum) {
		if (idx == N) {
			if (sum >= B) {
				ans = Math.min(sum, ans);
			}
			return;
		}

		if (sum > ans)
			return;

		visited[idx] = true;
		powerSet(idx + 1, sum(idx));
		visited[idx] = false;
		powerSet(idx + 1, sum);
	}

	public static int sum(int idx) {
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				tmp += employee[i];

			}
		}
		return tmp;
	}
}
