package Q16768_Mooyo_Mooyo;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	static boolean visited[][];
	static int a[][], N, K, col;
	static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
	static List<int[]> breakList;

	public static void main(String[] args) {
		FastReader rd = new FastReader();
		N = rd.nextInt();
		K = rd.nextInt();
		col = 10;

		a = new int[N][col];

		for (int i = 0; i < N; i++) {
			String str = rd.next();
			for (int j = 0; j < col; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}

		while (true) {
			visited = new boolean[N][col];
			breakList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < col; j++) {
					if (a[i][j] == 0 || visited[i][j]) continue;
					bfs(i, j);
				}
			}

			if (breakList.isEmpty()) break;
			else {
				for (int[] s : breakList) {
					a[s[0]][s[1]] = 0;
				}

				for (int i = 0; i < col; i++) {
					for (int j = N - 1; j > 0; j--) {
						if (a[j][i] == 0) {
							for (int k = j - 1; k >= 0; k--) {
								if (a[k][i] != 0) {
									int tmp = a[k][i];
									a[k][i] = a[j][i];
									a[j][i] = tmp;
									break;
								}
							}
						}
					}
				}
			}
			breakList.clear();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < col; j++) {
				sb.append(a[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static void bfs(int i, int j) {
		int num = a[i][j];
		List<int[]> currList = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i, j});
		currList.add(new int[]{i, j});
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= col || visited[nr][nc] || num != a[nr][nc])
					continue;

				visited[nr][nc] = true;
				q.add(new int[]{nr, nc});
				currList.add(new int[]{nr, nc});
			}
		}

		if (currList.size() >= K) {
			breakList.addAll(currList);
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
