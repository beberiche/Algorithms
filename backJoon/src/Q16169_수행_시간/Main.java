package Q16169_수행_시간;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();


		TreeMap<Integer, List<int[]>> m = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			int rank = rd.nextInt();
			int time = rd.nextInt();

			if (!m.containsKey(rank)) m.put(rank, new ArrayList<>());

			m.get(rank).add(new int[]{i, time});
		}

		int[] inDegree = new int[N];

		Iterator<Integer> iter1 = m.keySet().iterator();
		Iterator<Integer> iter2 = m.keySet().iterator();
		iter2.next();

		List<int[]> list[] = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		while (iter2.hasNext()) {
			Integer st = iter1.next();
			Integer ed = iter2.next();
			for (int[] a : m.get(st)) {
				for (int[] b : m.get(ed)) {
					list[a[0]].add(b);
					inDegree[b[0]]++;
				}
			}
		}


		Queue<int[]> q = new LinkedList<>();
		int[] dp = new int[N];
		for (int[] a : m.get(1)) {
			dp[a[0]] = a[1];
			q.add(new int[]{a[0], dp[a[0]]});
		}

		int ans = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int idx = curr[0];
			int cost = curr[1];

			ans = Math.max(ans, cost);

			for (int[] next : list[idx]) {
				int val = (idx - next[0]) * (idx - next[0]) + next[1] + dp[idx];
				dp[next[0]] = Math.max(dp[next[0]], val);
				inDegree[next[0]]--;
				if (inDegree[next[0]] == 0) {
					q.add(new int[]{next[0], dp[next[0]]});
				}
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
