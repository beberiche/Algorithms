package Q1229_육각수;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();

		List<Integer> list = new ArrayList<>();

		// 육각수 만들기
		list.add(1);
		int sum = 5;
		while (list.get(list.size() - 1) + sum <= N) {
			list.add(list.get(list.size() - 1) + sum);
			sum += 4;
		}


		int dp[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = 6;
			for (int s : list) {
				if (s > i) break;
				dp[i] = Math.min(dp[i], dp[i - s] + 1);
			}
		}

		System.out.println(dp[N]);
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

