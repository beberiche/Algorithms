package Q1167_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int data;
	int dist;

	public Node(int data, int dist) {
		this.data = data;
		this.dist = dist;
	}
}

public class Main {
	static List<Node> nodeList[];
	static boolean[] visited;
	static int maxNode = 0;
	static int maxDist = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());

		nodeList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
		}

		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			while (true) {
				int n2 = Integer.parseInt(st.nextToken());
				if (n2 == -1)
					break;
				int dist = Integer.parseInt(st.nextToken());

				nodeList[n1].add(new Node(n2, dist));
			}
		}

		visited = new boolean[V + 1];
		DFS(1, 0);
		visited = new boolean[V + 1];
		DFS(maxNode, 0);
		System.out.println(maxDist);
	}

	private static void DFS(int data, int dist) {
		// TODO Auto-generated method stub
		visited[data] = true;
		for (Node n : nodeList[data]) {
			if (visited[n.data])
				continue;
			DFS(n.data, dist + n.dist);
			visited[n.data] = false;
		}
		if (maxDist < dist) {
			maxDist = dist;
			maxNode = data;
		}
	}
}
