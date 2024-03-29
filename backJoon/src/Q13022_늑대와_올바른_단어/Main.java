package Q13022_늑대와_올바른_단어;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		String a[] = new String[14 + 1];
		for (int i = 1; i <= 14; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < i; j++) {
				sb.append("w");
			}
			for (int j = 0; j < i; j++) {
				sb.append("o");
			}
			for (int j = 0; j < i; j++) {
				sb.append("l");
			}
			for (int j = 0; j < i; j++) {
				sb.append("f");
			}
			a[i] = sb.toString();
		}

		FastReader rd = new FastReader();

		String str = rd.next();

		for (int i = 14; i >=1; i--) {
			str = str.replaceAll(a[i], "");
			if (str.equals("")) {
				System.out.println(1);
				return;
			}
		}
		System.out.print(0);
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

