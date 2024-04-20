package Q16987_계란으로_계란치기;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	private static int N, a[], b[], ans;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		a = new int[N];
		b = new int[N];

		for (int i = 0; i < N; i++) {
			a[i] = rd.nextInt();
			b[i] = rd.nextInt();
		}

		go(0, 0);
		System.out.println(ans);
	}

	private static void go(int idx, int cnt) {
		if (idx >= a.length) {
			ans = Math.max(cnt, ans);
			return;
		}

		if (a[idx] <= 0 || cnt == a.length - 1) {
			go(idx + 1, cnt);
			return;
		}

		int tmp = cnt;

		for (int i = 0; i < N; i++) {
			if (i == idx) continue;

			if (a[i] <= 0) continue;

			a[idx] -= b[i];
			a[i] -= b[idx];

			if (a[i] <= 0) {
				cnt++;
			}

			if (a[idx] <= 0) {
				cnt++;
			}

			go(idx + 1, cnt);

			a[idx] += b[i];
			a[i] += b[idx];
			cnt = tmp;
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