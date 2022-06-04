package Q3085_사탕게임;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		char[][] arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = temp[j];
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				char temp = arr[i][j];
				char temp2 = arr[i][j + 1];

				arr[i][j] = temp2;
				arr[i][j + 1] = temp;

				for (int r = 0; r < N; r++) {
					int cnt = 1;
					for (int c = 0; c < N - 1; c++) {
						if (arr[r][c] == arr[r][c + 1]) {
							cnt++;
						} else {
							cnt = 1;
						}
						ans = Math.max(cnt, ans);
					}
				}

				for (int r = 0; r < N; r++) {
					int cnt = 1;
					for (int c = 0; c < N - 1; c++) {
						if (arr[c][r] == arr[c + 1][r]) {
							cnt++;
						} else {
							cnt = 1;
						}
						ans = Math.max(cnt, ans);
					}
				}

				arr[i][j] = temp;
				arr[i][j + 1] = temp2;

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				char temp = arr[j][i];
				char temp2 = arr[j + 1][i];

				arr[j][i] = temp2;
				arr[j + 1][i] = temp;

				for (int r = 0; r < N; r++) {
					int cnt = 1;
					for (int c = 0; c < N - 1; c++) {
						if (arr[r][c] == arr[r][c + 1]) {
							cnt++;
						} else {
							cnt = 1;
						}
						ans = Math.max(cnt, ans);
					}
				}

				for (int r = 0; r < N; r++) {
					int cnt = 1;
					for (int c = 0; c < N - 1; c++) {
						if (arr[c][r] == arr[c + 1][r]) {
							cnt++;
						} else {
							cnt = 1;
						}
						ans = Math.max(cnt, ans);
					}

				}

				arr[j][i] = temp;
				arr[j + 1][i] = temp2;

			}
		}

		System.out.println(ans);
	}
}
