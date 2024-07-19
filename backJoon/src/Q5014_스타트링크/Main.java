package Q5014_스타트링크;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int F, G;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		F = sc.nextInt();
		int S = sc.nextInt();
		G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();

		bfs(S, new int[]{U, -D});
	}

	static void bfs(int s, int[] pos) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);

		boolean[] visited = new boolean[F + 1];
		int[] move = new int[F + 1];
		visited[s] = true;
		move[s] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == G) {
				System.out.println(move[now]);
				return;
			}

			for (int i = 0; i < 2; i++) {
				int next = now + pos[i];

				if (next <= F && next >= 1 && !visited[next]) {
					visited[next] = true;
					q.add(next);
					move[next] = move[now] + 1;
				}
			}
		}

		System.out.println("use the stairs");
	}
}