package Q17255_N으로_만들기;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	private static String a[];
	private static HashSet<String> s;
	private static int ans;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		a = rd.next().split("");
		s = new HashSet<>();
		ans = 0;
		for (int i = 0; i < a.length; i++) {
			go(i, i, a[i], a[i]);
		}
		System.out.println(ans);
	}

	private static void go(int l, int r, String curr, String process) {
		if (l == 0 && r == a.length - 1) {
			if (!s.contains(process)) {
				s.add(process);
				ans++;
			}
			return;
		}

		if (l - 1 >= 0) {
			String next = a[l - 1] + curr;
			go(l - 1, r, next, process + "/" + next);
		}

		if (r + 1 < a.length) {
			String next = curr + a[r + 1];
			go(l, r + 1, next, process + "/" + next);
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