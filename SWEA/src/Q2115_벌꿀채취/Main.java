package Q2115_벌꿀채취;

import java.util.Scanner;

class Honey {
	int cost, r, c;

	public Honey(int cost, int r, int c) {
		this.cost = cost;
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N; // 벌통의 크기
	static int M; // 선택할 수 있는 벌통의 개수
	static int C; // 꿀을 채취할 수 있는 최대양
	static Honey first, second;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 입력 끝

			first = new Honey(0, 0, 0);
			second = new Honey(0, 0, 0);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M - 1; j++) {
					harvest(i, j);
				}
			}

			System.out.println("#" + tc + " " + (first.cost + second.cost));
		}
	}

	private static void harvest(int r, int c) {
		int maxCost = 0; // 이번차례에 벌통에 구한 최댓값

		int[] tmp = new int[M];
		for (int i = 0; i < M; i++) {
			tmp[i] = map[r][c + i];
		}

		// 부분집합 구하기
		for (int i = 0; i < (1 << M); i++) {
			int sumHoney = 0;
			int sumCost = 0;
			for (int j = 0; j < M; j++) {
				if ((i & 1 << j) != 0) {
					sumHoney += tmp[j];
					sumCost += tmp[j] * tmp[j];
				}
			}
			// 이번 i번째 부분집합의 값을 계산해보았따.
			if (sumHoney <= C)
				maxCost = Math.max(maxCost, sumCost);
		}

		// 이번차례의 최고의 값이 내가 가지고 있는 first의 수익볻 더 많아.
		if (maxCost > first.cost) {
			// 1. 겹치는 경우
			if (r == first.r && c < first.c + M) {
				first = new Honey(maxCost, r, c);
			}
			// 2. 안겹치는 경우
			else {
				second = first;
				first = new Honey(maxCost, r, c);
			}
		} else if (maxCost > second.cost) {
			// 행이 다르거나 열이 겹치지 않는다면
			if (r != first.r || c >= first.c + M) {
				second = new Honey(maxCost, r, c);
			}
		}

	}

}
