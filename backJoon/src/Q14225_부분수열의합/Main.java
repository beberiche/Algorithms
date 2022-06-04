package Q14225_부분수열의합;

import java.util.Scanner;

public class Main {
	static boolean[] count = new boolean[2000001];

	static int[] arr;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			count[arr[i]] = true;
		}

		powerSet(0);
		for (int i = 1; i <= 2000001; i++) {
			if (!count[i]) {
				System.out.println(i);
				return;
			}
		}
	}

	private static void powerSet(int n) {
		// TODO Auto-generated method stub
		if (n == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			count[sum] = true;
			return;
		}

		visited[n] = true;
		powerSet(n + 1);
		visited[n] = false;
		powerSet(n + 1);

	}

}
