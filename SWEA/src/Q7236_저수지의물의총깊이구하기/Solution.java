package Q7236_저수지의물의총깊이구하기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input7236.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int ans = 0;
		for (int TC = 1; TC <= T; TC++) {
			// 입력
			int N = sc.nextInt();

			char[][] reservoir = new char[N][N];

			sc.nextLine();
			for (int i = 0; i < N; i++) {
				reservoir[i] = sc.nextLine().toString().replaceAll(" ", "").toCharArray();
			}
			;

			int st = 1;
			int ed = N - 2;

			int[] dy = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dx = { -1, 0, 1, 1, 1, 0, -1, -1 };

			// 탐색
			int max = 0;
			for (int i = st; i <= ed; i++) {
				for (int j = st; j <= ed; j++) {
					int cnt = 0;
					if (reservoir[i][j] == 'G') {
						continue;
					}
					for (int d = 0; d < 8; d++) {
						int ay = i + dy[d];
						int ax = j + dx[d];
						if (reservoir[ay][ax] == 'W')
							cnt++;
					}
					if (cnt == 0)
						max = 1;
					max = Math.max(cnt, max);

				}
			}
			System.out.printf("#%d %d\n", TC, max);
		}
	}
}
