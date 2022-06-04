package Q1733_오목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r = 0, c = 0, win = 0;
	static int[] dy = { 1, -1, 0, 1 }, dx = { 1, 1, 1, 0 };
	static int[][] board;
	static boolean check = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[19][19];
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		// 1. 인덱스 처리 먼저 해준후 해당 좌표 부터 같은 돌이 5개 있는 지 확인
		// 2. 같은 돌이 다섯개 있는 곳 가운데, 6개 이상이 되지 않는지 확인
		// 3. 여기까지 검증이 완료되었다면, 이후 해당 좌표의 r값 c값 그리고 이긴돌을 전달
		// 4. 반복문이 끝나고 만약 이긴사람이 정해지지 않았다며 무승부
		outer: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (board[i][j] != 0) {
					if (check) {
						break outer;
					}
					solve(i, j);
				}
			}
		}

		// 출력
		if (!check) {
			System.out.println(0);
		} else {
			System.out.println(win);
			System.out.println((r + 1) + " " + (c + 1));
		}
	}

	// 오목 확인하기
	private static void solve(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int cnt = 4;
			int y = i, x = j;
			// 우선 같은게 5개가 되는 지 확인
			while (true) {
				y += dy[k];
				x += dx[k];
				if (y < 0 || x < 0 || y >= 19 || x >= 19 || board[y][x] != board[i][j])
					break;
				if (board[y][x] == board[i][j])
					cnt--;
				if (cnt == 0) {
					check = true;
					r = i;
					c = j;
					win = board[i][j];
					break;
				}
			}

			if (check) {
				// 오목이 되었다면
				// 육목 이상인지 아닌지 확인
				int nextY = y + dy[k], nextX = x + dx[k];
				int prevY = i - dy[k], prevX = j - dx[k];
				if ((nextY >= 0 && nextX >= 0 && nextY < 19 && nextX < 19 && board[nextY][nextX] == board[i][j])) {
					check = false;
				}
				if (prevY >= 0 && prevX >= 0 && prevY < 19 && prevX < 19 && board[prevY][prevX] == board[i][j]) {
					check = false;
				}
				return;
			}
		}
	}
}
