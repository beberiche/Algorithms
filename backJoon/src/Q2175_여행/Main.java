package Q2175_여행;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static List<int[]> list[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		M = rd.nextInt();
		K = rd.nextInt();
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			int n1 = rd.nextInt();
			int n2 = rd.nextInt();
			int dist = rd.nextInt();

			if (n1 < n2) {
				list[n1].add(new int[]{n2, dist});
			}
		}

		int[][] dp = new int[N + 1][M + 1];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{1, 1});
		int ans = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll(); // node, cnt;

			if (curr[0] == N) {
				ans = Math.max(ans, dp[curr[0]][curr[1]]);
			}

			if (curr[1] + 1 > M) continue;

			for (int next[] : list[curr[0]]) {
				if (dp[next[0]][curr[1] + 1] < dp[curr[0]][curr[1]] + next[1]) {
					dp[next[0]][curr[1] + 1] = dp[curr[0]][curr[1]] + next[1];
					q.add(new int[]{next[0], curr[1] + 1});
				}
			}
		}

		System.out.println(ans);
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