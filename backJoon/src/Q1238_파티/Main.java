package Q1238_파티;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int to, time;

	public Edge(int to, int time) {
		this.to = to;
		this.time = time;
	}

	@Override
	public int compareTo(Edge o) {
		return this.time - o.time;
	}

}

public class Main {
	static List<Edge> adjList[];
	static List<Edge> adjListReversed[];
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE;
	static int N, M, G;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 학생=마을의 개수
		M = sc.nextInt(); // 마을 사이의 도로의 개수
		G = sc.nextInt(); // 도착해야하는 마을의 번호
		adjList = new ArrayList[N + 1];
		adjListReversed = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
			adjListReversed[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int time = sc.nextInt();
			adjList[from].add(new Edge(to, time));
			adjListReversed[to].add(new Edge(from, time));
		}

		int[] dist = dijkstra(adjList);
		int[] distReversed = dijkstra(adjListReversed);

		int ans = 0;
		for (int i = 1; i <= N; i++)
			ans = Math.max(ans, dist[i] + distReversed[i]);
		System.out.println(ans);

	}

	public static int[] dijkstra(List<Edge> list[]) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[G] = 0;

		pq.add(new Edge(G, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (visited[curr.to])
				continue;

			visited[curr.to] = true;

			for (Edge next : list[curr.to]) {
				if (!visited[next.to] && dist[next.to] > dist[curr.to] + next.time) {
					dist[next.to] = dist[curr.to] + next.time;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}

		return dist;
	}
}
