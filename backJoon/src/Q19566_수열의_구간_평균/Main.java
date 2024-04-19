package Q19566_수열의_구간_평균;

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
		long a[] = new long[N];
		for (int i = 0; i < N; i++) {
			a[i] = rd.nextLong();
		}

		long sum[] = new long[N + 1];
		HashMap<Long, Integer> m = new HashMap<>();
		long ans = 0;
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + a[i - 1];
			long ret = sum[i] - 1L * K * i;

			if (!m.containsKey(ret)) m.put(ret, 1);
			else {
				ans += m.get(ret);
				m.put(ret, m.get(ret) + 1);
			}

		}

		if (m.containsKey(0L)) {
			ans += m.get(0L);
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
