package Q15683_감시;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pos {
	int r, c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] copyMap;
	static List<Pos> list;
	static int[] sel;
	static int[] data = { 0, 1, 2, 3 };
//	static int[][] direction = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 },
//			{ 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, // 1번 카메라
//			{ 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, // 2번 카메라
//			{ 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 }, // 3번 카메라
//			{ 1, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, // 4번 카메라
//			{ 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, // 5번 카메라
//	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copyMap = new int[N][M];
		list = new ArrayList<>();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0)
					cnt++;
				if (map[i][j] >= 1 && map[i][j] <= 5)
					list.add(new Pos(i, j));
			}
		}

		if (list.size() == 0) {
			System.out.println(cnt);
			return;
		}

		sel = new int[list.size()];

	}
}
