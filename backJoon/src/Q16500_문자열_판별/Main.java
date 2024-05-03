package Q16500_문자열_판별;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	static String S, A[];
	static int dp[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		S = rd.next();
		int N = rd.nextInt();
		A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = rd.next();
		}

		dp = new int[S.length()];

		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < N; j++) {
				String str = A[j];
				if ((i == 0 || dp[i - 1] == 1) && i + str.length() <= S.length() && S.substring(i, i + str.length()).equals(A[j])) {
					dp[i + str.length() - 1] = 1;
				}
			}
		}
		System.out.println(dp[S.length() - 1]);
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
