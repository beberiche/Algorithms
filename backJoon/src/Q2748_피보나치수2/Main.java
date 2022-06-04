package Q2748_피보나치수2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N == 0) {
			System.out.println(0);
			return;
		} else if (N == 1 || N == 2) {
			System.out.println(1);
			return;
		} else {
			long[] arr = new long[91];
			arr[1] = 1;
			arr[2] = 1;
			for (int i = 3; i <= N; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
			System.out.println(arr[N]);
		}
	}
}
