package Q3933_라그랑주의_네_제곱수_정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int d = 1 << 15;
		int dp[][] = new int[d][4];

		for (int i = 1; i * i < d; i++) {
			dp[i * i][0] = 1;

			for (int j = i * i; j < d; j++) {
				dp[j][1] += dp[j - i * i][0];
				dp[j][2] += dp[j - i * i][1];
				dp[j][3] += dp[j - i * i][2];
			}
		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				System.out.print(sb.toString());
				return;
			}
			int ret = dp[num][0] + dp[num][1] + dp[num][2] + dp[num][3];
			sb.append(ret).append("\n");
		}
	}
}
