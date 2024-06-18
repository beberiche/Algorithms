package Q3933_라그랑주의_네_제곱수_정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 1 << 15;
		int d = (int) Math.sqrt(n);
		int dp[] = new int[n];

		for (int i = 1; i <= d; i++) {
			int ret1 = i * i;
			dp[ret1]++;
			for (int j = i; j <= d; j++) {
				int ret2 = j * j;
				if (ret1 + ret2 < n) dp[ret1 + ret2]++;
				for (int k = j; k <= d; k++) {
					int ret3 = k * k;
					if (ret1 + ret2 + ret3 < n) dp[ret1 + ret2 + ret3]++;
					for (int l = k; l <= d; l++) {
						int ret4 = l * l;
						if (ret1 + ret2 + ret3 + ret4 < n) dp[ret1 + ret2 + ret3 + ret4]++;
					}
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				System.out.print(sb.toString());
				return;
			}
			sb.append(dp[num]).append("\n");
		}
	}
}
