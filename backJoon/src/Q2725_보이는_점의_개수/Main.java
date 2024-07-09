package Q2725_보이는_점의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = 1001;
		int dp[] = new int[C];
		dp[1] = 3;
		for (int i = 2; i < C; i++) {
			int cnt = 0;
			for (int j = 0; j < i; j++) {
				if (GCD(i, j) == 1) cnt++;
			}
			dp[i] = dp[i - 1] + (2 * cnt);
		}

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(--T>=0) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int GCD(int i, int j) {
		if (j == 0) return i;
		return GCD(j, i % j);
	}
}
