package Q1753_최단경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int to, weight;

	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}

public class Main {
	static int V, E, st;
	static List<Edge>[] list;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		st = sc.nextInt();

		list = new ArrayList[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		Arrays.fill(dist, INF);

		for (int i = 1; i <= E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			list[from].add(new Edge(to, weight));
		}

		dijkstra();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		pq.add(new Edge(st, 0));

		dist[st] = 0;

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (visited[curr.to])
				continue;

			visited[curr.to] = true;

			for (Edge e : list[curr.to]) {
				if (dist[e.to] > dist[curr.to] + e.weight) {
					dist[e.to] = dist[curr.to] + e.weight;
					pq.add(new Edge(e.to, dist[e.to]));
				}
			}

		}
	}
}
