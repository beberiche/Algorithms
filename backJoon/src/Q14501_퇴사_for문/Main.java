package Q14501_퇴사_for문;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// int ti = sc.nextInt(); // int pi = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			int idx = i;
			for (int j = i; j < N; j += idx) {
				idx = arr[idx][0];
				if (idx < N) {
					sum += arr[j][1];
				}

			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
