package Q2606_바이러스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> graph[];
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정점의 수
		int M = Integer.parseInt(br.readLine()); // 간선의 수

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		BFS(1);
		System.out.println(ans);
	}

	public static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int g : graph[curr])
				if (!visited[g]) {
					q.add(g);
					visited[g] = true;
					ans++;
				}
		}

	}
}
