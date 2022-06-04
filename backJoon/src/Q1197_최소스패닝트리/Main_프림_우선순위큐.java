package Q1197_최소스패닝트리;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_프림_우선순위큐 {
	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		List<Edge> list[] = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int weight = sc.nextInt();

			list[st].add(new Edge(st, ed, weight));
			list[ed].add(new Edge(ed, st, weight));
		}

		boolean[] visited = new boolean[V];

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

		visited[1] = true;
		pq.addAll(list[1]);

		int cnt = 1;
		int ans = 0;

		while (cnt != V) {
			Edge edge = pq.poll();
			if (visited[edge.to])
				continue;

			ans += edge.weight;
			pq.addAll(list[edge.to]);
			visited[edge.to] = true;
			cnt++;
		}

		System.out.println(ans);
	}
}
