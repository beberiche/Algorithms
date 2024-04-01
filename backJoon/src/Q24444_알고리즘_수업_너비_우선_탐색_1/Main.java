package Q24444_알고리즘_수업_너비_우선_탐색_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static List<Integer> list[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int R = Integer.parseInt(stk.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			list[n1].add(n2);
			list[n2].add(n1);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}

		bfs(N, R, list);
	}

	private static void bfs(int N, int R, List<Integer> list[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(R);

		boolean visited[] = new boolean[N + 1];
		visited[R] = true;

		int ret[] = new int[N+1];
		int idx = 1;
		while (!q.isEmpty()) {
			int curr = q.poll();
			ret[curr] = idx++;
			for (int n : list[curr]) {
				if (visited[n]) continue;

				visited[n] = true;
				q.add(n);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(ret[i]).append("\n");
		}

		System.out.print(sb.toString());
	}
}
