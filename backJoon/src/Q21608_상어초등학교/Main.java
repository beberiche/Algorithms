package Q21608_상어초등학교;

import java.util.Scanner;

// * |r1-r2| + |c1-c2| = 1 => 4방탐색
// 1. 비어있는 칸중에서 좋아하는 학생과 인접한 곳이 가장 많은 자리로 이동합니다.
// 1-1. 만약 맨처음 학생이 자리를 찾는 경우라면, 그사람의 좌표는 4방탐색이 모두 허용가능한 곳 가운데 좌표가 가장 작은 값 입니다.
// 2. 1을 만족하는 경우가 여러개라면 그 가운데 빈칸이 가장 많은 칸의 자리를 정합니다.
// 3. 2도 만족하는 경우가 여러개라면 그 가운데 r값이 가장 작은 좌표를 택합니다.
// 4. 3도 만족하는 경우가 여러개라면 그 가운데 c값이 가장 작은 좌표를 택합니다.
// 5. 자리의 점수를 정합니다.

public class Main {
	static int ans;
	static int N;
	static int[] order;
	static int[][] follows, seats;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static final int[] seatScore = { 0, 1, 10, 100, 1000 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		order = new int[N * N];
		follows = new int[N * N + 1][];
		seats = new int[N][N];
		for (int i = 0; i < N * N; i++) {
			order[i] = sc.nextInt();
			follows[order[i]] = new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt() };
		}

		// 1-1. 만약 맨처음 학생이 자리를 찾는 경우라면, 그사람의 좌표는 4방탐색이 모두 허용가능한 곳 가운데 좌표가 가장 작은 값 입니다.
		seats[1][1] = order[0];

		// 자리를 찾습니다.
		mySeats();
		// 만족도 계산
		mySeatScore();

		System.out.println(ans);
	}

	public static void mySeats() {
		for (int i = 1; i < N * N; i++) {
			int maxWeight = -1;
			int bestR = -1, bestC = -1;
			int student = order[i];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (seats[r][c] != 0)
						continue;
					int weight = 0;

					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						// 2. 1을 만족하는 경우가 여러개라면 그 가운데 빈칸이 가장 많은 칸의 자리를 정합니다.
						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;

						if (seats[nr][nc] == 0) {
							weight += 1;
							continue;
						}
						// 1. 비어있는 칸중에서 좋아하는 학생과 인접한 곳이 가장 많은 자리로 이동합니다.
						for (int f = 0; f < 4; f++) {
							if (seats[nr][nc] == follows[student][f]) {
								weight += 10;
							}
						}
					}
					if (maxWeight < weight) {
						maxWeight = weight;
						bestR = r;
						bestC = c;
					}
				}
			}
			seats[bestR][bestC] = student;
		}
	}

	// 5. 자리의 점수를 정합니다.
	public static void mySeatScore() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int scoreIdx = 0;
				int student = seats[r][c];
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					for (int f = 0; f < 4; f++) {
						if (seats[nr][nc] == follows[student][f]) {
							scoreIdx++;
						}
					}
				}
				ans += seatScore[scoreIdx];
			}
		}
	}

}
