package Q7465_창용마을무리의개수;

import java.util.Scanner;

public class Solution {
	static int[] map;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 사람의 수
			int M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수
			cnt = 0;
			map = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				map[i] = i;
			}

			for (int i = 0; i < M; i++) {
				union(sc.nextInt(), sc.nextInt());
			}

			for (int i = 1; i <= N; i++) {
				if (map[i] == i) {
					cnt++;
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

	static void union(int x, int y) {
		int nx = findSet(x);
		int ny = findSet(y);

		map[ny] = nx;
	}

	static int findSet(int d) {
		if (map[d] == d) {
			return d;
		} else {
			return map[d] = findSet(map[d]);
		}
	}
}
