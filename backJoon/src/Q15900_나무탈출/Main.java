package Q15900_나무탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dist;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 그래프를 위한 리스트 배열 생성
		graph = new ArrayList[N + 1];
		// 박문철
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList();

		// 양방향 연결
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		BFS(1);
		System.out.println(ans % 2 == 1 ? "Yes" : "No");
	}

	public static void BFS(int idx) {
		// int 배열 을 받는 큐 생성
		// [0] 노드 데이터
		// [1] depth 값
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { idx, 0 });
		visited[idx] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			// 자식 노드인지 확인
			boolean isLeaf = true;
			for (int ch : graph[curr[0]]) {
				// 이미 방문된 곳은 넘기기
				if (!visited[ch]) {
					isLeaf = false;
					visited[ch] = true;
					q.add(new int[] { ch, curr[1] + 1 });
				}
			}
			// 만일 리프라면, depth값 만큼 추가
			if (isLeaf) {
				ans += curr[1];
			}
		}

	}
}
