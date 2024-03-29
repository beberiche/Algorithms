package Q15813_준표와_조약돌;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();

		int N = rd.nextInt();
		int B = rd.nextInt();
		int W = rd.nextInt();

		char[] c = rd.chArr();

		int b_cnt = 0;
		int w_cnt = 0;
		int l = 0;
		int r = 0;

		int ans = 0;
		while (r < N) {

			if (b_cnt > B) {
				if (c[l] == 'W') w_cnt--;
				else b_cnt--;
				l++;
			} else {
				r++;
				if (c[r - 1] == 'W') w_cnt++;
				else b_cnt++;
			}

			if (b_cnt <= B && w_cnt >= W) {
				ans = Math.max(ans, r - l);
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

		char[] chArr() {
			char[] tmp;
			try {
				tmp = br.readLine().toCharArray();
			} catch (IOException e) {
				tmp = null;
			}

			return tmp;
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
