package Q10974_순열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		int[] output = new int[N];
		boolean[] visited = new boolean[N];
		perm(arr, output, visited, 0, N, N);

	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int N, int r) {
		if (depth == r) {
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					System.out.print(output[i] + " ");
				}
			}
			System.out.println();
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, N, r);
				visited[i] = false;
			}
		}
	}

}
