package Q1939_중량제한;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

}

public class Main {
	static int N, M;
	static int[] dist;
	static List<Node> adjList[];
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		st = new StringTokenizer(br.readLine());

		int ST = Integer.parseInt(st.nextToken()); // A 공장 출발
		int ED = Integer.parseInt(st.nextToken()); // B 공장 도착

		dijkstra(ST);
		System.out.println(dist[ED]);
	}

	private static void dijkstra(int start) {
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MIN_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.weight - o1.weight);
		pq.add(new Node(start, INF));
		dist[start] = INF;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (dist[curr.to] > curr.weight)
				continue;

			for (Node next : adjList[curr.to]) {
				int minWeight = Math.min(curr.weight, next.weight);

				if (minWeight <= dist[next.to])
					continue;

				dist[next.to] = minWeight;
				pq.add(new Node(next.to, minWeight));
			}
		}

	}
}