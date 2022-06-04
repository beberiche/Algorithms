package Q2309_일곱난쟁이;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> list;
	static int sum;
	static int[] arr;
	static boolean[] visited;
	static int len;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[9];
		sum = 0;
		len = arr.length;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		visited = new boolean[arr.length];

		comb(0, 2);
	}

	static void comb(int st, int r) {
		if (r == 0) {
			int nonD = 0;
			for (int i = 0; i < len; i++) {
				if (visited[i]) {
					nonD += arr[i];
				}
			}

			if (sum - nonD == 100) {
				check();
				for (int l : list) {
					System.out.println(l);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(i + 1, r - 1);
				visited[i] = false;
			}
		}
	}

	static void check() {
		list = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				list.add(arr[i]);
			}
		}
		Collections.sort(list);
	}
}
