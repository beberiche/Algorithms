package Q14863_서울에서_경산까지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		int[][][] a = new int[N + 1][2][];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			a[i][0] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
			a[i][1] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
		}

		int dp[][] = new int[N + 1][K + 1];


		for (int j = 0; j < 2; j++) {
			int t = a[1][j][0];
			int c = a[1][j][1];
			dp[1][t] = Math.max(dp[1][t], c);
		}


		int ans = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 2; j++) {
				int t = a[i][j][0];
				int c = a[i][j][1];
				for (int k = 0; k <= K - t; k++) {
					if (dp[i - 1][k] == 0) continue;
					dp[i][k + t] = Math.max(dp[i][k + t], dp[i - 1][k] + c);
					if (i == N) ans = Math.max(ans, dp[i][k + t]);
				}
			}
		}
		System.out.println(ans);
	}
}
