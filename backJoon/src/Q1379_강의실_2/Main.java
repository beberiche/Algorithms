package Q1379_강의실_2;

// Authored by: beberiche
// Co-authored by: -
// Link:

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		FastReader rd = new FastReader();
		int N = rd.nextInt();

		PriorityQueue<int[]> pq1 = new PriorityQueue<>((n1, n2) -> {
			if (n1[1] == n2[1]) return n1[2] - n2[2];
			return n1[1] - n2[1];
		}); // 시작시간을 기점으로 오름차순;
		for (int i = 0; i < N; i++) {
			int id = rd.nextInt();
			int st = rd.nextInt();
			int ed = rd.nextInt();
			pq1.add(new int[]{id, st, ed});
		}

		// {r_id, id, ed}
		PriorityQueue<int[]> pq2 = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]); // 끝나는 시간을 기준으로 오름차순
		int[] room = new int[N + 1];
		int[] curr = pq1.poll();
		room[curr[0]] = 1;
		pq2.add(new int[]{room[curr[0]], curr[2]});
		while (!pq1.isEmpty()) {
			curr = pq1.poll();
			int rId = pq2.size() + 1;
			if (pq2.peek()[1] <= curr[1]) rId = pq2.poll()[0];
			room[curr[0]] = rId;
			pq2.add(new int[]{room[curr[0]], curr[2]});
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq2.size()).append("\n");
		for (int i = 1; i <= N; i++) {
			sb.append(room[i]).append("\n");
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
