package Q2813_소수의개수;

import java.util.Scanner;

public class Main {
	static int cnt;
	static int[] arr = new int[2000001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		if (M < N) {
			check(N);
			cntUp(M, N);
		} else {
			check(M);
			cntUp(N, M);
		}
		System.out.println(cnt);

	}

	private static void check(int num) {
		// TODO Auto-generated method stub
		arr[0] = arr[1] = 1;
		for (int i = 2; i * i <= num; i++) {
			if (arr[i] == 0) {
				for (int j = i * i; j <= num; j += i) {
					arr[j] = 1;
				}
			}
		}
	}

	private static void cntUp(int s, int m) {
		for (int i = s; i <= m; i++) {
			if (arr[i] == 0) {
				cnt++;
			}
		}
	}
}
