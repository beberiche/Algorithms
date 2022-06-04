package Q1647_도시분할계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
	int to, weight;

	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

}

public class Main2 {
	static List<Edge> adjList[];
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선

		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Edge(to, weight));
			adjList[to].add(new Edge(from, weight));
		}

		System.out.println(mstPrim());

	}

	public static int mstPrim() {
		Queue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);

		boolean[] visited = new boolean[N + 1];

		q.addAll(adjList[1]);
		visited[1] = true;

		int mst = 0;
		int maxW = 0;
		while (!q.isEmpty()) {
			Edge curr = q.poll();

			if (visited[curr.to])
				continue;

			visited[curr.to] = true;
			mst += curr.weight;
			maxW = Math.max(curr.weight, maxW);
			for (Edge next : adjList[curr.to]) {
				q.add(next);
			}
		}

		return mst - maxW;
	}
}
