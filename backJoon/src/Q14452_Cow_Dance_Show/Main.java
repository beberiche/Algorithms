package Q14452_Cow_Dance_Show;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int max = rd.nextInt();
		int l = 1;
		int r = N;
		int a[] = new int[N];

		for (int i = 0; i < N; i++) {
			a[i] = rd.nextInt();
		}

		while (l < r) {
			int mid = (l + r) / 2;
			if (check(mid, a, max)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(r);
	}

	private static boolean check(int mid, int[] a, int max) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int idx;
		for (idx = 0; idx < mid; idx++) {
			pq.add(a[idx]);
		}

		int ret = 0;
		while (!pq.isEmpty()) {
			ret = pq.poll();
			if (ret > max) return false;
			if (idx < a.length) pq.add(a[idx++] + ret);
		}

		return ret <= max;
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
