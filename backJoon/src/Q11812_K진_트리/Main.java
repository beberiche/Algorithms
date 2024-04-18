package Q11812_K진_트리;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		rd.nextLong();
		int K = rd.nextInt();
		int Q = rd.nextInt();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			long a = rd.nextLong();
			long b = rd.nextLong();
			if (K == 1) {
				sb.append(Math.abs(b - a)).append("\n");
				continue;
			}

			long ans = 0;
			while (a != b) {
				if (a < b)
					b = (b - 2) / K + 1;
				else
					a = (a - 2) / K + 1;
				ans++;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
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
