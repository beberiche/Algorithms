package Q18223_민준이와마산그리고건우;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int v, w;

	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.w - o.w;
	}

}

public class Main {
	static final String HIM = "SAVE HIM";
	static final String BYE = "GOOD BYE";
	static int V, E, P;
	static List<Node>[] adjList;
	static int[] dist;
	static final int INF = 10001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		P = sc.nextInt(); // 건우가 존재하는 정점

		adjList = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			adjList[i] = new ArrayList();

		for (int i = 1; i <= E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			adjList[st].add(new Node(ed, w));
			adjList[ed].add(new Node(st, w));
		}

		dijkstra(1); // 총 최단경로
		int zeroToEnd = dist[V]; // 처음부터 끝까지
		int zeroToP = dist[P]; // 처음부터 건우까지
		dijkstra(P); // 건우 -> 마산
		int pToEnd = dist[V]; // 건우부터 끝까지

//		System.out.println(pToEnd == 0 ? HIM : BYE);
//		System.out.println(zeroToEnd == zeroToP + pToEnd ? HIM : BYE);
	}

	static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(st, 0));

		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		dist[st] = 0;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			for (Node node : adjList[curr.v]) {
				if (dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}

	}
}
