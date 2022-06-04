package Q5650_핀볼게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class WormHole {
	int r, c;

	public WormHole(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static int N;
	static int map[][];
	static WormHole wormHole[][];
	static final int[] dr = new int[] { -1, 1, 0, 0 };
	static final int[] dc = new int[] { 0, 0, -1, 1 };
	static int ans;
	static int score;

	public static void main(String[] args) throws Exception {
		// 1. 0에서 4방향으로 갈 때의 모든 경우의 수를 구한다.
		// 2-1. 블록 or 벽에 부딪히는 경우 점수를 올린다.
		// 2-2. 웜홀을 만난다면 같은 웜홀로 이동한다.(방향은 그대로 해야함)
		// 3. 출발위치 혹은 블랙홀에 빠지면 그동안 모은 점수를 반환하고 게임이 종료된다.
		// 4. 최대 점수와 현재 점수를 비교하고 1~3을 계속 반복한다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			wormHole = new WormHole[5][2]; // 최대 5개

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 5) {
						if (wormHole[map[i][j] - 6][0] == null) {
							wormHole[map[i][j] - 6][0] = new WormHole(i, j);
						} else {
							wormHole[map[i][j] - 6][1] = new WormHole(i, j);
						}
					}
				}
			}

			ans = 0;
			// 0이면 게임 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							map[i][j] = -1; // 시작하는 곳을 블랙홀로 만들자
							ans = Math.max(ans, gameStart(i, j, d));
							map[i][j] = 0; // 끝났으면 되돌려놔야지
						}
					}
				}

			}
			System.out.println("#" + t + " " + ans);
		}
	}

	public static int gameStart(int r, int c, int d) {
		// 0 :상 1 :하 2 :좌 3 :우
		int nr = r;
		int nc = c;
		score = 0;

		while (true) {
			nr += dr[d];
			nc += dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				score++;
				if (d % 2 == 0)
					d++;
				else
					d--;
				continue;
			}

			// 블랙홀에 빠지면 끝
			if (map[nr][nc] == -1)
				break;

			// 이동하는 곳이 0이면 계속 전진
			if (map[nr][nc] == 0)
				continue;

			// 상하좌우 순으로 내려온다.
			if (map[nr][nc] == 1) { // ◣
				if (d == 0)
					d = 1;
				else if (d == 1)
					d = 3;
				else if (d == 2)
					d = 0;
				else if (d == 3)
					d = 2;
				score++;
			} else if (map[nr][nc] == 2) { // ◤
				if (d == 0)
					d = 3;
				else if (d == 1)
					d = 0;
				else if (d == 2)
					d = 1;
				else if (d == 3)
					d = 2;
				score++;
			} else if (map[nr][nc] == 3) { // ◥
				if (d == 0)
					d = 2;
				else if (d == 1)
					d = 0;
				else if (d == 2)
					d = 3;
				else if (d == 3)
					d = 1;
				score++;
			} else if (map[nr][nc] == 4) { // ◢
				if (d == 0)
					d = 1;
				else if (d == 1)
					d = 2;
				else if (d == 2)
					d = 3;
				else if (d == 3)
					d = 0;
				score++;
			} else if (map[nr][nc] == 5) { // ■
				if (d == 0)
					d = 1;
				else if (d == 1)
					d = 0;
				else if (d == 2)
					d = 3;
				else if (d == 3)
					d = 2;
				score++;
			}

			if (map[nr][nc] > 5) {
				int tempR = 0;
				int tempC = 0;
				if (nr == wormHole[map[nr][nc] - 6][0].r && nc == wormHole[map[nr][nc] - 6][0].c) {
					tempR = wormHole[map[nr][nc] - 6][1].r;
					tempC = wormHole[map[nr][nc] - 6][1].c;
				} else {
					tempR = wormHole[map[nr][nc] - 6][0].r;
					tempC = wormHole[map[nr][nc] - 6][0].c;
				}
				nr = tempR;
				nc = tempC;
			}
		}
		return score;
	}
}
