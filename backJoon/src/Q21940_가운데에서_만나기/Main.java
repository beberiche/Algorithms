package Q21940_가운데에서_만나기;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();
		int M = rd.nextInt();

		int[][] a = new int[N + 1][N + 1];

		int INF = (int) 1e9;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(a[i], INF);
			a[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			int n1 = rd.nextInt();
			int n2 = rd.nextInt();
			int t = rd.nextInt();

			a[n1][n2] = t;
		}


		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (a[i][j] > a[i][k] + a[k][j]) {
						a[i][j] = a[i][k] + a[k][j];
					}
				}
			}
		}

		int K = rd.nextInt();
		int f[] = new int[K];

		for (int i = 0; i < K; i++) {
			f[i] = rd.nextInt();
		}

		List<Integer> list = new ArrayList<>();
		int curr = INF;
		for (int i = 1; i <= N; i++) {
			int ret = 0;
			for (int j = 0; j < K; j++) {
				ret = Math.max(ret, a[i][f[j]] + a[f[j]][i]);
			}
			if (curr >= ret) {
				if (curr > ret) {
					curr = ret;
					list.clear();
				}
				list.add(i);
			}
		}
		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (int n : list) {
			sb.append(n).append(" ");
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