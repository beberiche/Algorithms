package Q3124_최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Edge {
		int ed;
		int cost;

		public Edge(int ed, int cost) {
			this.ed = ed;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 인접 리스트 만들기
			List<Edge>[] adjList = new ArrayList[V + 1];
			boolean[] visited = new boolean[V + 1];

			for (int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int fr = Integer.parseInt(st.nextToken());
				int re = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				adjList[fr].add(new Edge(re, w));
				adjList[re].add(new Edge(fr, w));
			}

			PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

			visited[1] = true;
			pq.addAll(adjList[1]);

			int cnt = 1;
			long ans = 0;

			while (cnt != V) {
				Edge edge = pq.poll();
				if (visited[edge.ed])
					continue;

				ans += edge.cost;
				pq.addAll(adjList[edge.ed]);
				visited[edge.ed] = true;
				cnt++;
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}
