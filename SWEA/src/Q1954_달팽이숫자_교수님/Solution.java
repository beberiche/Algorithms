package Q1954_달팽이숫자_교수님;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());

			int[][] sneil = new int[N][N];
			int r = 0;
			int c = -1;
			int size = N;
			int delta = 1;
			int cnt = 1;

			while (true) {
				for (int i = 0; i < size; i++) {
					c += delta;
					sneil[r][c] = cnt;
					cnt++;
				}

				size--;

				if (size < 0) {
					break;
				}

				for (int j = 0; j < size; j++) {
					r += delta;
					sneil[r][c] = cnt;
					cnt++;
				}
				delta *= -1;
			}

			System.out.printf("#%d\n", TC);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(sneil[i][j] + " ");
				}
				System.out.println();
			}

		}

	}
}
