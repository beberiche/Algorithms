package Q4386_별자리만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int to;
	double len;

	public Edge(int to, double len) {
		this.to = to;
		this.len = len;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.len, o.len);
	}
}

class Star {
	int r, c;

	public Star(int r, int c) {
		this.r = r;
		this.c = c;
	}

}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 별(정점)의 개수

		List<Edge>[] list = new ArrayList[n];

		for (int i = 0; i < n; i++)
			list[i] = new ArrayList<>();

		// 별 넣기
		Star[] star = new Star[n];
		for (int i = 0; i < n; i++)
			star[i] = new Star((int) sc.nextDouble(), (int) sc.nextDouble());

		// 간선 작업하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				double tempLen = Math.sqrt(Math.pow(star[i].r - star[j].r, 2) + Math.pow(star[i].c - star[j].c, 2));
				list[i].add(new Edge(j, tempLen));
			}
		}

		boolean[] visited = new boolean[n];

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		visited[0] = true;
		pq.addAll(list[0]);

		int cnt = 1;
		double ans = 0;

		while (true) {
			if (cnt == n)
				break;

			Edge edge = pq.poll();

			if (visited[edge.to])
				continue;

			visited[edge.to] = true;
			ans += edge.len;
			pq.addAll(list[edge.to]);
			cnt++;
		}

		System.out.println(Math.round(ans * 100) / 100.0);
	}
}
