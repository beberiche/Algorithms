package Q1263_시간_관리;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int[][] a = new int[N][2];

		for (int i = 0; i < N; i++) {
			a[i][0] = rd.nextInt();
			a[i][1] = rd.nextInt();
		}

		Arrays.sort(a, (n1, n2) -> n2[1] - n1[1]);
		
		int ans = a[0][1] - a[0][0];
		for (int i = 1; i < N; i++) {
			if (a[i][1] < ans) ans = a[i][1];
			ans -= a[i][0];
		}

		System.out.println((ans < 0) ? -1 : ans);
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
