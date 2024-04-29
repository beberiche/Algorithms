package Q1344_축구;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	static double a, b, dp[][][];
	static int N;
	static HashSet<Integer> s;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = 18; // 90분을 5분씩 나누었을 때, 각 팀은 18회의 골을 넣을 찬스를 가진다.
		a = rd.nextDouble() / 100;
		b = rd.nextDouble() / 100;
		s = new HashSet<>(Arrays.asList(new Integer[]{2, 3, 5, 7, 11, 13, 17}));
		dp = new double[N + 1][N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1d);
			}
		}

		System.out.printf("%.7f", 1d - go(0, 0, 0));
	}

	private static double go(int idx, int t1, int t2) {
		if (idx >= N) {
			return dp[idx][t1][t2] = !s.contains(t1) && !s.contains(t2) ? 1d : 0d;
		}

		if (dp[idx][t1][t2] != -1d) return dp[idx][t1][t2];

		double ret1 = go(idx + 1, t1 + 1, t2 + 1) * a * b; // 두 팀 모두 넣는 경우
		double ret2 = go(idx + 1, t1 + 1, t2) * a * (1d - b); // a 팀만 넣는 경우
		double ret3 = go(idx + 1, t1, t2 + 1) * (1d - a) * b; // b 팀만 넣는 경우
		double ret4 = go(idx + 1, t1, t2) * (1d - a) * (1d - b); // a,b 모두 못 넣는 경우
		return dp[idx][t1][t2] = ret1 + ret2 + ret3 + ret4;
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
