package Q5972_택배_배송;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M, INF = (int) 1e9, dist[];
	private List<int[]> list[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(dist[N]);
	}

	private void solve() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		pq.add(new int[]{1, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (int[] next : list[curr[0]]) {
				if (dist[next[0]] > curr[1] + next[1]) {
					dist[next[0]] = curr[1] + next[1];
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			list[n1].add(new int[]{n2, dist});
			list[n2].add(new int[]{n1, dist});
		}
	}
}
