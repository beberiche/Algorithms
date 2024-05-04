package Q31778_PPC_만들기;

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
		char[] a = rd.next().toCharArray();

		int l = 0;
		int r = N - 1;

		while (K > 0 && l < r) {
			while (l < N && a[l] == 'P') l++;
			while (r > 0 && a[r] == 'C') r--;

			if (l < r) {
				K--;
				char tmp = a[l];
				a[l] = a[r];
				a[r] = tmp;
			}
		}

		long sum = 0;
		long ret = 0;
		for (int i = 0; i < N; i++) {
			if (a[i] == 'P') sum++;
			else ret += sum * (sum - 1) / 2;
		}

		System.out.println(ret);
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