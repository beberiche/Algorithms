package Q14621_나만안되는연애;

import java.util.PriorityQueue;
import java.util.Scanner;

class Edge {
	int from, to;
	int weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}

public class Main {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		char[] gender = new char[V + 1];
		for (int i = 1; i <= V; i++) {
			gender[i] = sc.next().charAt(0);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>((E1, E2) -> E1.weight - E2.weight);

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();

			pq.add(new Edge(from, to, weight));
		}

		// makeSet
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < E; i++) {
			Edge curr = pq.poll();

			int px = findSet(curr.from);
			int py = findSet(curr.to);

			if (px != py && gender[curr.from] != gender[curr.to]) {
				p[py] = px;
				ans += curr.weight;
				cnt++;
			}
		}
		System.out.println(cnt == V - 1 ? ans : -1);
	}

	private static int findSet(int n) {
		if (n == p[n]) {
			return n;
		}
		return p[n] = findSet(p[n]);
	}
}
