package Q1182_부분수열의합;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int S;
	static int N;
	static int cnt = 0;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();

		arr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		powerSet(0, 0);
		System.out.println(cnt);

	}

	public static void powerSet(int idx, int sum) {
		if (idx == N) {
			boolean flag = false;
			for (boolean v : visited) {
				if (v) {
					flag = true;
					break;
				}
			}
			if (flag && sum == S)
				cnt++;

			return;
		}

		visited[idx] = true;
		powerSet(idx + 1, sum + arr[idx]);
		visited[idx] = false;
		powerSet(idx + 1, sum);
	}
}
