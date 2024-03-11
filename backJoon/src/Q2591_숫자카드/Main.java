package Q2591_숫자카드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[] dp;
	private static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		dp = new int[str.length()];
		Arrays.fill(dp, -1);
		go(0);
		System.out.println(dp[0] == -1 ? 0 : dp[0]);
	}

	private static int go(int idx) {
		if (idx >= str.length()) {
			return 1;
		}

		if (dp[idx] != -1) {
			return dp[idx];
		}

		if (str.charAt(idx) == '0') return 0;

		int ret = 0;

		int curr = -1;
		int next = -1;
		if (idx < str.length() - 1) {
			curr = str.charAt(idx) - '0';
			next = str.charAt(idx + 1) - '0';
			int num = curr * 10 + next;
			if (num <= 34) ret = go(idx + 2);
		}
		if (next != 0) ret += go(idx + 1);
		return dp[idx] = ret;
	}
}
