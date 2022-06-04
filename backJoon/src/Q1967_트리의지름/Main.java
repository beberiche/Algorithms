package Q1967_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int data;
	int dist;

	Node(int data, int dist) {
		this.data = data;
		this.dist = dist;
	}
}

public class Main {
	// 이젠 그냥 그래프가 편합니다.
	static ArrayList<Node> graph[];
	static boolean[] visited;
	// 최장경로
	static int maxDist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 입력값 설정
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d1 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			graph[d1].add(new Node(d2, dist));
			graph[d2].add(new Node(d1, dist));
		}

		// 모든 루트를 시작점으로 다 돌아보자
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			DFS(i, 0);
		}
		System.out.println(maxDist);
	}

	public static void DFS(int data, int dist) {
		visited[data] = true;
		for (Node n : graph[data]) {
			if (!visited[n.data]) {
				DFS(n.data, dist + n.dist);
				// 다른 자식도 있는 경우도 돌아봐야하니
				// 해당 노드 방문처리 해제
				visited[n.data] = false;
			}
		}
		// 자식 노드까지 갔다면 그동안 더해온 dist 값 넣어주기
		maxDist = Math.max(maxDist, dist);
	}
}
