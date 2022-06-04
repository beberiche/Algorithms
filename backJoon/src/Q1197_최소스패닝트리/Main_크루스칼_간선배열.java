package Q1197_최소스패닝트리;

import java.util.Arrays;
import java.util.Scanner;

public class Main_크루스칼_간선배열 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}

		Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);

		// makeSet
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		int ans = 0;
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				p[py] = px;
				ans += edges[i][2];
			}

		}

		System.out.println(ans);
	}

	private static int findSet(int i) {
		if (p[i] == i) {
			return i;
		}
		return p[i] = findSet(p[i]);
	}

}