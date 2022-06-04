package Q1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> graph[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 정점 번호

		graph = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 1; i < M + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		visited = new boolean[N + 1];
		DFS(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		BFS(V);

		System.out.println(sb.toString());
	}

	public static void DFS(int num) {
		visited[num] = true;
		sb.append(num).append(" ");
		Collections.sort(graph[num]);
		for (int n : graph[num]) {
			if (visited[n])
				continue;
			DFS(n);
		}
	}

	public static void BFS(int num) {
		Queue<Integer> q = new LinkedList<>();
		visited[num] = true;
		q.add(num);

		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			Collections.sort(graph[curr]);
			for (int n : graph[curr]) {
				if (visited[n])
					continue;
				visited[n] = true;
				q.add(n);
			}
		}
	}
}
