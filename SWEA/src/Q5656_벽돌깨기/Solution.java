package Q5656_벽돌깨기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, W, H;
	static int[][] map;
	static int[][] copyMap;
	static int[] sel;
	static int ans;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 구슬 횟수
			W = sc.nextInt(); // width 값
			H = sc.nextInt(); // height 값

			map = new int[H][W];
			copyMap = new int[H][W];
			sel = new int[N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 1. 공을 떨어뜨리는 곳의 모든 경우의 수를 구한다.
			// 같은 곳에서 또 떨어뜨려도 되며 순서에 따라서 남아있는 블럭이 달라지기도 할테니 중복 순열을 사용한다.
			perm(0);
			System.out.println("#" + t + " " + ans);
		}
	}

	public static void perm(int cnt) {
		if (cnt == N) {
			copyMapInit(); // 공을 놓기 전 맵을 복사하자.
			for (int i = 0; i < N; i++) {
				int fixedC = sel[i]; // sel값이 공의 column 값이 된다.
				int r = firstBox(sel[i]);
				if (r != -1) {
					dropBall(r, fixedC);
					dropBox();
				}
			}
			ans = Math.min(ans, count());
			return;
		}

		for (int i = 0; i < W; i++) {
			sel[cnt] = i;
			perm(cnt + 1);
		}
	}

	// 0이 아닌 벽돌에 도달하도록 r의 좌표를 바꿔준다.
	private static int firstBox(int c) {
		for (int i = 0; i < H; i++) {
			if (copyMap[i][c] > 0) {
				return i;
			}
		}
		return -1;
	}

	// 볼이 박스를 부순다. BFS를 활용하여, 해당 박스가 제거 될 때 박스의 값만큼 연쇄 제거가 일어나도록 한다.
	public static void dropBall(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c, copyMap[r][c] });
		copyMap[r][c] = 0;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int b = 1; b < curr[2]; b++) {
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d] * b;
					int nc = curr[1] + dc[d] * b;

					if (nr < 0 || nc < 0 || nr >= H || nc >= W)
						continue;

					if (copyMap[nr][nc] == 0)
						continue;

					q.add(new int[] { nr, nc, copyMap[nr][nc] });
					copyMap[nr][nc] = 0;
				}
			}
		}
	}

	// 해당 경우에서 박스가 제거된 이후, 떠있는 박스를 내린다.
	public static void dropBox() {
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < H; i++) {
				if (copyMap[i][j] == 0) {
					if (i - 1 >= 0 && copyMap[i - 1][j] != 0) {
						int temp = copyMap[i - 1][j];
						copyMap[i - 1][j] = copyMap[i][j];
						copyMap[i][j] = temp;
						i -= 2;
					}
				}
			}
		}
	}

	// 남아있는 박스의 수를 센다.
	public static int count() {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copyMap[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 매 생성된 조합마다 map을 새로 설정해준다.
	public static void copyMapInit() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}
