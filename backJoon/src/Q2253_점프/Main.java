package Q2253_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, dp[][], a[], INF;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		dp = new int[N + 1][150];

		a = new int[N + 1];
		INF = 10004;
		for (int i = 0; i < M; i++) {
			int idx = Integer.parseInt(br.readLine());
			a[idx] = INF;
		}

		int ret = go(1, 0);
		System.out.println(ret == INF ? -1 : ret);
	}

	private static int go(int idx, int x) {
		if (idx == N) {
			return 0;
		}

		if (idx > N || a[idx] == INF) {
			return INF;
		}

		if (dp[idx][x] != 0) {
			return dp[idx][x];
		}

		int ret = INF;

		ret = Math.min(ret, go(idx + x + 1, x + 1));
		if (x > 0) ret = Math.min(ret, go(idx + x, x));
		if (x - 1 > 0) ret = Math.min(ret, go(idx + x - 1, x - 1));

		return dp[idx][x] = ret == INF ? ret : ret + 1;
	}
}
