package Q1976_여행가자;

import java.util.Scanner;

public class Main {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 도시의 수
		int M = sc.nextInt(); // 여행 갈 도시의 수

		p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (sc.nextInt() == 1)
					union(i, j);
			}
		}

	int rep = findSet(sc.nextInt());
		// 여행 도시가 M개면
		// 간선의 개수는 M-1
		for (int i = 1; i < M; i++) {
			if (rep != findSet(sc.nextInt())) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}

	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	private static int findSet(int n) {
		if (n == p[n])
			return n;
		return p[n] = findSet(p[n]);
	}
}
