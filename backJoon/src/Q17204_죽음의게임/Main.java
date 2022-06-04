package Q17204_죽음의게임;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
		}

		BFS(0);
	}

	private static void BFS(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited = new boolean[N];
		int cnt = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == M || cnt > N) {
				visited[M] = true;
				break;
			}

			if (visited[curr])
				continue;

			visited[curr] = true;
			q.add(map[curr]);
			cnt++;
		}

		System.out.println(!visited[M] ? -1 : cnt);
	}
}
