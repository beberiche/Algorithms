package Q2644_촌수계산;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> list[];
	static boolean visited[];
	// 해당 촌수가 닿지 않는 경우 -1이 출력되어야 하니
	// 초기화를 -1로 설정
	static int ans = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체 사람의 수
		int p1 = sc.nextInt(); // 촌수를 계산해야하는 사람
		int p2 = sc.nextInt(); // 촌수를 계산해야하는 사람2
		int M = sc.nextInt(); // 간선의 수

		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			list[n1].add(n2);
			list[n2].add(n1);
		}

		BFS(p1, p2, 0);

		System.out.println(ans);
	}

	public static void BFS(int p1, int p2, int depth) {
		Queue<int[]> q = new LinkedList<>();
		// 해당 사람과 시작점 부터의 촌수를 넣는다.
		// [0] 사람
		// [1] 이어지는 촌수
		visited[p1] = true;
		q.add(new int[] { p1, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			// 찾으려는 사람이 큐에서 뽑뽑하면
			// 걔가 지금껏 가져온 촌수의 수를 뱉는다.
			if (curr[0] == p2) {
				ans = curr[1];
				break;
			}
			for (int l : list[curr[0]]) {
				if (!visited[l]) {
					visited[l] = true;
					q.add(new int[] { l, curr[1] + 1 });
				}
			}
		}
	}
}
