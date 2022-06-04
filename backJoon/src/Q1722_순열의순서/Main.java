package Q1722_순열의순서;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int idx;
	static String str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] output = new int[N];
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		boolean[] visited = new boolean[N];

		if (sc.nextInt() == 1) {
			idx = sc.nextInt();
			perm(arr, output, visited, 0, N, N);
		} else {
			str = sc.nextLine().replace(" ", "");
			perm2(arr, output, visited, 0, N, N);
		}
	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int N, int r) {
		if (r == depth) {
			if (idx == 1) {
				for (int i = 0; i < N; i++) {
					System.out.print(output[i] + " ");
				}
				System.out.println();
				System.exit(0);
			} else {
				idx -= 1;
				return;
			}
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

	static void perm2(int[] arr, int[] output, boolean[] visited, int depth, int N, int r) {
		if (r == depth) {
			if (str.equals(Arrays.toString(output).replaceAll("[^0-9]", ""))) {
				System.out.println(idx + 1);
				System.exit(0);
			} else {
				idx++;
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm2(arr, output, visited, depth + 1, N, r);
				visited[i] = false;
			}
		}
	}
}
