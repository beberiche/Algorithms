package Q1800_인터넷_설치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static List<int[]> list[];
	private static int N, K, INF;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		int P = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		INF = (int) 1e9 + 4;
		int l = 0;
		int r = 0;
		for (int i = 0; i < P; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			list[n1].add(new int[]{n2, dist});
			list[n2].add(new int[]{n1, dist});

			r = Math.max(dist, r);
		}

		r++;
		boolean check = false;
		while (l < r) {
			int mid = (l + r) / 2;
			if (check(mid)) {
				check = true;
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(check ? r : -1);
	}

	private static boolean check(int mid) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		dist[1] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		// 노드, dist 총합, k
		pq.add(new int[]{1, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (dist[curr[0]] < curr[1]) continue;

			for (int[] next : list[curr[0]]) {
				int c = next[1] > mid ? 1 : 0;
				if (dist[next[0]] > curr[1] + c) {
					dist[next[0]] = curr[1] + c;
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}

		return dist[N] <= K;
	}
}
