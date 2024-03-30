package Q18311_왕복;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();

		int N = rd.nextInt();
		long K = rd.nextLong();
		int a[] = new int[N + 1];
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			a[i] = rd.nextInt();
			sum += a[i];
			if (K < sum) {
				System.out.println(i);
				return;
			}
		}

		int idx = N;
		for (int i = N + 1; i <= N * 2; i++) {
			sum += a[idx];
			if (K < sum) {
				System.out.println(idx);
				return;
			}
			idx--;
		}
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
