package Q1402_약수구하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (N % i == 0)
				arr[i] = 1;
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (arr[i] == 1) {
				++cnt;
				if (cnt == K) {
					System.out.println(i);
					return;
				}
			}
		}
		System.out.println(0);
	}
}
