package Q1197_최소스패닝트리;

import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}

// 우선순위 큐를 활용한 크루스칼
public class Main_크루스칼_우선순위큐 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int weight = sc.nextInt();

			pq.add(new Edge(st, ed, weight));
		}

		p = new int[V + 1];

		// makeSet
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		int ans = 0;
		for (int i = 1; i <= E; i++) {
			Edge curr = pq.poll();
			int px = findSet(curr.from);
			int py = findSet(curr.to);

			if (px != py) {
				p[py] = px;
				ans += curr.weight;
			}
		}

		System.out.println(ans);
	}

	private static int findSet(int n) {
		if (n == p[n]) {
			return n;
		}
		return p[n] = findSet(p[n]);
	}
}