package 프림;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 프림2_우선순위큐 {
	static class Edge implements Comparable<Edge> {
		int st;
		int ed;
		int cost;

		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		// 우선순위 큐를 만들어야 하니 최소 힙으로
		public int compareTo(Edge o) {
			return this.cost - o.cost;
//			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 갯수
		int E = sc.nextInt();

		// 간선의 정보를 저장을 해아한다.
		// 인접행렬 혹은 인접리스트 사용
		List<Edge>[] adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();

			adjList[st].add(new Edge(st, ed, w));
			adjList[ed].add(new Edge(ed, st, w));
		}

		boolean[] visited = new boolean[V]; // 방문처리

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		visited[0] = true;
		pq.addAll(adjList[0]); // 이거 갖고 있는 거 모두 넣어줘

		int cnt = 1; // 확보한 정점의 갯수
		int ans = 0;

		while (cnt != V) {
			Edge edge = pq.poll(); // 간선하나 꺼내기
			if (visited[edge.ed])
				continue;

			ans += edge.cost;
			pq.addAll(adjList[edge.ed]);
			visited[edge.ed] = true;
			cnt++;
		}
		System.out.println(ans);

	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n";
}
