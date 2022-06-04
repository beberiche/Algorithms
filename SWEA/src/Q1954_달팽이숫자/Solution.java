package Q1954_달팽이숫자;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1954.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();

			int[][] sneil = new int[N][N];

			if (N == 1) { // N이 만약 1이면 굳이 방향전환을 설정할 필요가 없다..
				sneil[0][0] = 1;
			} else { // 방향 전환 설정하기
				for (int j = 0; j < N; j++) { // 일단 배열 맨 상층은 기본적으로 채워 놓고 시작하겠음.
					sneil[0][j] = j + 1;
				}

				int num = N + 1; // 현재 들어가야할 넘버
				int r = 0; // 행
				int c = N - 1; // 열
				int move = c; // 다음 회전까지 움직일 수 있는 정도
				int cnt = move; // 한 칸 움직일때 마다 소모
				int dir = 0; // 움직일 방향
								// 배열 맨위는 이미 채웠으니 초기값은 down!

				int down = 0;
				int left = 1;
				int up = 2;
				int right = 3;

				while (true) {
					// 숫자가 배열 칸 갯수보다 많아지면 끝
					if (num > N * N) {
						break;
					}

					// r, c 좌표 설정;
					if (dir == down) {
						r++;
					} else if (dir == left) {
						c--;
					} else if (dir == up) {
						r--;
					} else {
						c++;
					}

					sneil[r][c] = num;
					num++;
					cnt--;

					// 해당 방향의 끝점까지 도달했을 경우
					if (cnt == 0) {
						if (dir % 2 == 1) { // 방향이 현재 left, right라면 움직일 수 있는 값을 하나 줄인다.
							move--;
						}

						if (dir == down || dir == left || dir == up) {
							dir++;
						} else {
							dir = 0; // right라면 up으로!
						}
						cnt = move;
					}
				}
			}

			System.out.printf("#%d\n", TC);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%d ", sneil[i][j]);
				}
				System.out.println();
			}

		}
	}
}
