package Q9470_Strahler_순서;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int T = rd.nextInt();
		StringBuilder sb = new StringBuilder();
		while (--T >= 0) {
			int K = rd.nextInt();
			int M = rd.nextInt();
			int P = rd.nextInt();

			boolean[][] adj = new boolean[M + 1][M + 1];
			int[] inDegree = new int[M + 1];
			for (int i = 0; i < P; i++) {
				int st = rd.nextInt();
				int ed = rd.nextInt();
				adj[st][ed] = true;
				inDegree[ed]++;
			}


			Queue<Integer> q = new LinkedList<>();
			int[] strahler = new int[M + 1];
			int[] cnt = new int[M + 1];
			for (int i = 1; i <= M; i++) {
				if (inDegree[i] == 0) {
					q.add(i);
					strahler[i] = 1;
				}
			}

			int ans = 1;
			while (!q.isEmpty()) {
				int curr = q.poll();
				if (cnt[curr] > 1) strahler[curr]++;

				ans = Math.max(ans, strahler[curr]);

				for (int next = 1; next <= M; next++) {
					if (adj[curr][next]) {
						inDegree[next]--;
						if (strahler[next] < strahler[curr]) {
							strahler[next] = strahler[curr];
							cnt[next] = 1;
						} else if (strahler[next] == strahler[curr]) {
							cnt[next]++;
						}

						if (inDegree[next] == 0) {
							q.add(next);
						}
					}
				}
			}

			sb.append(K).append(" ").append(ans).append("\n");
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
