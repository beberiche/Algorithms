package Q6137_문자열_생성;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int S = rd.nextInt();
		char[] c = new char[S];

		for (int i = 0; i < S; i++) {
			c[i] = rd.next().charAt(0);
		}

		int l = 0;
		int r = S - 1;
		StringBuffer sb = new StringBuffer();
		while (l <= r) {
			if (c[l] == c[r]) {
				int ll = l;
				int rr = r;
				boolean check = false;
				while (ll <= rr) {
					if (c[ll] == c[rr]) {
						ll++;
						rr--;
					} else if (c[ll] < c[rr]) {
						sb.append(c[l++]);
						check = true;
						break;
					} else {
						sb.append(c[r--]);
						check = true;
						break;
					}
				}

				if (!check) {
					sb.append(c[l++]);
				}
			} else if (c[l] < c[r]) {
				sb.append(c[l++]);
			} else {
				sb.append(c[r--]);
			}
		}

		StringBuilder ans = new StringBuilder();
		ans.append(sb.charAt(0));
		for (int i = 1; i < sb.length(); i++) {
			if (i % 80 == 0) ans.append("\n");
			ans.append(sb.charAt(i));
		}
		System.out.print(ans);
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
