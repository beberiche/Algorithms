package Q1493_수의_새로운_연산;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1493.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int ans = 0;

		int N = 350;
		int[][] arr = new int[N][N];

		// 대각선 방향으로 증가하는 이차원 배열 만들기
		int cnt = 1;
		for (int i = 0; i < Math.pow(N, 2) - Math.pow(N - 1, 2); i++) {
			for (int j = 0; j < N; j++) {
				if (i - j >= 0 && i - j < N - 1) {
					arr[i - j][j] = cnt;
					cnt++;
				}
			}
		}

		for (int TC = 1; TC <= T; TC++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			int r1 = 0; // p의 r좌표
			int c1 = 0; // p의 c좌표
			int r2 = 0; // q의 r좌표
			int c2 = 0; // q의 c좌표
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (p == arr[i][j]) {
						r1 = i;
						c1 = j;
					}
					if (q == arr[i][j]) {
						r2 = i;
						c2 = j;
					}
				}
			}

			// 문제에서의 인덱스는 1,1 에서 시작하므로
			// 1씩 추가해주자.
			ans = arr[r1 + r2 + 1][c1 + c2 + 1];

			System.out.printf("#%d %d\n", TC, ans);
		}
	}
}
