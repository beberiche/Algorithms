package Q1916_최소비용구하기;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int to, cost;

	public Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}

}

public class Main {
	static List<Edge> adjList[];
	static boolean[] visited;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 도시의 개수
		int M = sc.nextInt(); // 도시 사이를 이동하는 버스의 개수
		adjList = new ArrayList[N + 1];
		dist = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
			dist[i] = INF;
		}

		for (int i = 0; i < M; i++)
			adjList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));

		int st = sc.nextInt();
		int ed = sc.nextInt();

		visited = new boolean[N + 1];
		dist[st] = 0;
		dijkstra(st);
		System.out.println(dist[ed]);
	}

	public static void dijkstra(int st) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.add(new Edge(st, 0));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (visited[curr.to])
				continue;

			visited[curr.to] = true;

			for (Edge next : adjList[curr.to]) {
				if (!visited[next.to] && dist[next.to] > dist[curr.to] + next.cost) {
					dist[next.to] = dist[curr.to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
	}
}
