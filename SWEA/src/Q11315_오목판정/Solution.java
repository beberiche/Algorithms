package Q11315_오목판정;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[] dy = { 0, 1, 1, 1 };
	static int[] dx = { 1, 0, 1, -1 };
	static boolean check;
	static char[][] board;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input11315.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int TC = 1; TC <= T; TC++) {
			// 입력
			N = sc.nextInt();
			check = false;

			board = new char[N][N];

			for (int i = 0; i < N; i++)
				board[i] = sc.next().toCharArray();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 'o')
						solve(i, j);
				}
			}

			System.out.printf("#%d %s\n", TC, check ? "YES" : "NO");
		}

	}

	private static void solve(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int cnt = 4;
			int mul = 1;
			while (true) {
				int r = i + dy[k] * mul;
				int c = j + dx[k] * mul;
				if (r < 0 || r >= N || c < 0 || c >= N || board[r][c] != 'o')
					break;
				if (board[r][c] == 'o') {
					cnt--;
					mul++;
				}
				if (cnt == 0) {
					check = true;
					break;
				}
			}
		}
	}
}
