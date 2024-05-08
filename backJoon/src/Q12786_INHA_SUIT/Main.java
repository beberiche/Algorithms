package Q12786_INHA_SUIT;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int K = rd.nextInt();
		int H = 21;
		int[][] a = new int[N + 1][];
		a[0] = new int[]{1};
		for (int i = 1; i <= N; i++) {
			int cnt = rd.nextInt();
			a[i] = new int[cnt];
			for (int j = 0; j < cnt; j++) {
				a[i][j] = rd.nextInt();
			}
		}

		int[][] dp = new int[N + 1][H];
		int INF = 51;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], 51);
		}

		for (int i = 0; i < N; i++) {
			for (int curr : a[i]) {
				if (dp[i][curr] == INF) continue;

				// o
				dp[i + 1][curr] = Math.min(dp[i][curr], dp[i + 1][curr]);

				// a
				if (curr + 1 < H) {
					dp[i + 1][curr + 1] = Math.min(dp[i][curr], dp[i + 1][curr + 1]);
				}
				// b
				dp[i + 1][Math.min(20, curr * 2)] = Math.min(dp[i][curr], dp[i + 1][Math.min(20, curr * 2)]);

				// c
				if (curr - 1 > 0) {
					dp[i + 1][curr - 1] = Math.min(dp[i][curr], dp[i + 1][curr - 1]);
				}

				for (int next : a[i + 1]) {
					dp[i + 1][next] = Math.min(dp[i][curr] + 1, dp[i + 1][next]);
				}
			}
		}


		int ans = INF;
		for (int val : a[N]) {
			ans = Math.min(ans, dp[N][val]);
		}

		System.out.println(ans > K ? -1 : ans);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

/* Solution Description



 */
