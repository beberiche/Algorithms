package Q1240_노드사이의거리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int child, dist;

	public Node(int child, int dist) {
		this.child = child;
		this.dist = dist;
	}
}

public class Main {
	static List<Node> tree[];
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 출력해야하는 노드 쌍의 갯수

		tree = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			tree[n1].add(new Node(n2, n3));
			tree[n2].add(new Node(n1, n3));
		}

		for (int i = 0; i < M; i++) {
			visited = new boolean[N + 1];
			DFS(sc.nextInt(), sc.nextInt(), 0);
			System.out.println(ans);
		}
		sc.close();
	}

	private static void DFS(int from, int to, int dist) {
		visited[from] = true;

		if (from == to) {
			ans = dist;
			return;
		}

		for (Node n : tree[from]) {
			if (!visited[n.child]) {
				DFS(n.child, to, dist + n.dist);
			}
		}
	}
}
