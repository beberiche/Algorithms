package Q15809_전국시대;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	static int[] a, p;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int M = rd.nextInt();
		a = new int[N + 1];
		p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			a[i] = rd.nextInt();
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int cmd = rd.nextInt();
			int x = find(rd.nextInt());
			int y = find(rd.nextInt());
			if (cmd == 1) {
				p[y] = x;
				a[x] += a[y];
			} else {
				if (a[y] == a[x]) {
					p[y] = 0;
					p[x] = 0;
				} else if (a[y] > a[x]) {
					a[y] -= a[x];
					p[x] = y;
				} else {
					a[x] -= a[y];
					p[y] = x;
				}
			}
		}

		Set<Integer> s = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			int num = find(i);
			if (num != 0) s.add(find(i));
		}

		StringBuffer sb = new StringBuffer();
		sb.append(s.size()).append("\n");
		List<Integer> list = new ArrayList<>();
		for (int num : s) {
			list.add(a[num]);
		}
		Collections.sort(list, (n1, n2) -> n1 - n2);
		for (int num : list) {
			sb.append(num).append(" ");
		}
		System.out.print(sb.toString());
	}

	private static int find(int num) {
		if (p[num] == num) return num;
		return p[num] = find(p[num]);
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
