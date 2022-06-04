package Q1961_숫자배열회전;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1961.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int ans = 0;
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();

			int[][] arr = new int[N][N];
			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			StringBuilder sb = new StringBuilder();

			sb.append("#").append(TC).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					sb.append(arr[j][i]);
				}
				sb.append(" ");

				for (int j = N - 1; j >= 0; j--) {
					sb.append(arr[N - 1 - i][j]);
				}
				sb.append(" ");

				for (int j = 0; j < N; j++) {
					sb.append(arr[j][N - 1 - i]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
//			System.out.printf("#%d %s\n", TC, sb);
		}
	}
}
