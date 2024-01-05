package Q2602_돌다리_건너기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	String str1, str2, str3;
	int dp[][][];
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		ans += m.solve(0, 0, 0);
		ans += m.solve(1, 0, 0);
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private int solve(int check, int idx1, int idx2) {
		if (idx1 >= str1.length()) {
			return 1;
		}

		if (idx2 >= str2.length()) {
			return 0;
		}

		if (dp[check][idx1][idx2] != -1) {
			return dp[check][idx1][idx2];
		}

		dp[check][idx1][idx2] = 0;
		for (int i = idx2; i < str2.length(); i++) {
			dp[check][idx1][idx2] += isValid(check, idx1, i) ? solve((check + 1) % 2, idx1 + 1, i + 1) : 0;
		}

		return dp[check][idx1][idx2];
	}


	private boolean isValid(int check, int idx1, int i) {
		return (check == 0 && str1.charAt(idx1) == str2.charAt(i)) || (check == 1 && str1.charAt(idx1) == str3.charAt(i));
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		str3 = br.readLine();

		dp = new int[2][str1.length()][str2.length()];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < str1.length(); j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
	}
}
