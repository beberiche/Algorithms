package kruskal;

import java.util.Arrays;
import java.util.Scanner;

public class 크루스칼 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // V : 정점의 갯수 인데 0 부터 시작이야
		int E = sc.nextInt(); // E : 간선의 갯수

		// 크루스칼을 사용하려면 간선배열을 이용해야해
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt(); // [0] 시작점,
			edges[i][1] = sc.nextInt(); // [1] 끝점
			edges[i][2] = sc.nextInt(); // [2] 가중치
		}
		// 간선을 가중치로 오름차순 정렬을 해야해~~~
		Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);

		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}

		int ans = 0;

		// mst 만들어보자.
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
			}
		}

		System.out.println(ans);
	}

//	static void makeSet(int x) {
//		p[x] = x;
//	}

	static int findSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = findSet(p[x]);
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n";
}
