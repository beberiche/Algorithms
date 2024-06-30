package Q10835_카드게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, a[], b[], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		a = new int[N + 1];
		b = new int[N + 1];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			b[i] = Integer.parseInt(stk.nextToken());
		}


		dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}

		int ret = go(1, 1);
		System.out.println(ret);
	}

	private static int go(int i, int j) {
		if (i > N || j > N) {
			return 0;
		}

		if (dp[i][j] != -1) return dp[i][j];

		int ret = 0;

		// 조건 1
		ret = Math.max(go(i + 1, j), go(i + 1, j + 1));
		// 조건 2
		if (a[i] > b[j]) {
			ret = Math.max(ret, go(i, j + 1) + b[j]);
		}

		return dp[i][j] = ret;
	}
}
