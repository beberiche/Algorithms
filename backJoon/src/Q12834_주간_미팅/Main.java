package Q12834_주간_미팅;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, V, E, A, B, sum, INF;
	private int[] home;
	private List<int[]> list[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(sum);
	}

	private void solve() {
		sum = 0;
		INF = (int) 1e9 + 4;
		for (int i = 0; i < N; i++) {
			sum += dijkstra(home[i]);
		}
	}

	private int dijkstra(int start) {
		int dist[] = new int[V];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		pq.add(new int[]{start, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (int[] next : list[curr[0]]) {
				if (dist[next[0]] > curr[1] + next[1]) {
					dist[next[0]] = curr[1] + next[1];
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}
		if (dist[A] == INF) dist[A] = -1;
		if (dist[B] == INF) dist[B] = -1;

		return dist[A] + dist[B];
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		A = Integer.parseInt(stk.nextToken()) - 1;
		B = Integer.parseInt(stk.nextToken()) - 1;

		stk = new StringTokenizer(br.readLine());
		home = new int[N];
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(stk.nextToken()) - 1;
		}


		list = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken()) - 1;
			int n2 = Integer.parseInt(stk.nextToken()) - 1;
			int dist = Integer.parseInt(stk.nextToken());

			list[n1].add(new int[]{n2, dist});
			list[n2].add(new int[]{n1, dist});
		}
	}
}
