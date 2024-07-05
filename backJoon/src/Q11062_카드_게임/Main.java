package Q11062_카드_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int a[], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (--T >= 0) {
			int N = Integer.parseInt(br.readLine());
			a = new int[N];
			dp = new int[N][N];
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(stk.nextToken());
				Arrays.fill(dp[i], -1);
			}
			sb.append(go(0, N - 1, 0)).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int go(int l, int r, int cnt) {
		if (l > r) {
			return 0;
		}

		if (dp[l][r] != -1) return dp[l][r];

		if (cnt % 2 == 0) {
			return dp[l][r] = Math.max(a[l] + go(l + 1, r, cnt + 1), a[r] + go(l, r - 1, cnt + 1));
		} else {
			return dp[l][r] = Math.min(go(l + 1, r, cnt + 1), go(l, r - 1, cnt + 1));
		}
	}
}
