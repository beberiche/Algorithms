package Q25603_짱해커_이동식;

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
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = rd.nextInt();
		}

		int st = 0;
		int ed = K - 1;

		int max = 0;
		while (ed < a.length) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			for (int i = st; i <= ed; i++) {
				if (min > a[i]) {
					idx = i;
					min = a[i];
				}
			}
			st = idx + 1;
			ed = st + (K - 1);

			if (min > max) {
				max = min;
			}
		}

		System.out.println(max);

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