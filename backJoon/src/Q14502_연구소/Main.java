package Q14502_연구소;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Virus {
	int r, c;

	public Virus(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int[][] map, copyMap;
	static List<Virus> list;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static int N, M;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		copyMap = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int data = sc.nextInt();
				if (data == 2)
					list.add(new Virus(i, j));
				map[i][j] = data;
			}
		}

		// 1. 벽을 세운다.
		makeWall(0);

		System.out.println(ans);
	}

	public static void makeWall(int cnt) {
		if (cnt == 3) {
			// 2. 전염시킨다.
			BFS();
			// 3. 안전영역을 구한다.
			ans = Math.max(ans, safetyZone(copyMap));
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static void BFS() {
		Queue<Virus> q = new LinkedList<>();

		q.addAll(list);

		copyMapInit();
		while (!q.isEmpty()) {
			Virus curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (copyMap[nr][nc] == 1 || copyMap[nr][nc] == 2)
					continue;

				copyMap[nr][nc] = 2;
				q.add(new Virus(nr, nc));
			}
		}
	}

	public static int safetyZone(int[][] copyMap) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void copyMapInit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}
