package Q10422_괄호;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		long dp[] = new long[5001];
		dp[0] = 1;

		int MOD = 1_000_000_007;
		for (int i = 2; i <= 5000; i += 2) {
			dp[i] = go(dp, MOD, 0, i - 2);
			dp[i] %= MOD;
		}


		FastReader rd = new FastReader();

		int T = rd.nextInt();

		for (int i = 0; i < T; i++) {
			System.out.println(dp[rd.nextInt()]);
		}
	}

	private static long go(long[] dp, int MOD, int st, int ed) {
		int l = st;
		int r = ed;

		long ret = 0;
		while (l < r) {
			ret += 2 * ((dp[l] * dp[r]) % MOD) % MOD;
			l += 2;
			r -= 2;
		}
		if (l == r) ret += (dp[l] * dp[r]) % MOD;

		return ret;
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
