package Q2406_안정적인_네트워크;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	static int N, M, p[];

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		M = rd.nextInt();

		p = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int x = rd.nextInt();
			int y = rd.nextInt();

			int xx = find(x);
			int yy = find(y);
			if (xx < yy) {
				p[yy] = xx;
			} else {
				p[xx] = yy;
			}
		}

		int[][] a = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				a[i][j] = rd.nextInt();
			}
		}
		// from, to, cost
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[2] - n2[2]);

		for (int i = 2; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				pq.add(new int[]{i, j, a[i][j]});
			}
		}

		int sum = 0;
		List<int[]> list = new ArrayList<>();
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			int x = find(curr[0]);
			int y = find(curr[1]);

			if (x == y) continue;

			if (x < y) {
				p[y] = x;
			} else {
				p[x] = y;
			}

			sum += curr[2];
			list.add(new int[]{curr[0], curr[1]});
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sum).append(" ").append(list.size()).append("\n");
		for (int[] arr : list) {
			sb.append(arr[0]).append(" ").append(arr[1]).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
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