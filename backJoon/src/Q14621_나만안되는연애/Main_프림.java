package Q14621_나만안되는연애;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_프림 {
	static class Edge {
		int from, to;
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

		char[] gender = new char[V + 1];
		for (int i = 1; i <= V; i++) {
			gender[i] = sc.next().charAt(0);
		}

		List<Edge> list[] = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();

			if (gender[from] != gender[to]) {
				list[from].add(new Edge(from, to, weight));
				list[to].add(new Edge(to, from, weight));
			}
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>((E1, E2) -> E1.weight - E2.weight);

		boolean[] visited = new boolean[V + 1];
		visited[1] = true;
		pq.addAll(list[1]);

		int cnt = 1;
		int ans = 0;

		while (cnt != V) {
			try {
				Edge edge = pq.poll();
				if (visited[edge.to])
					continue;

				ans += edge.weight;
				visited[edge.to] = true;
				pq.addAll(list[edge.to]);
			} catch (Exception e) {
				ans = -1;
				break;
			}
			cnt++;
		}

		System.out.println(ans);

	}
}
