package Q2798_블랙잭;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int bj = sc.nextInt(); // blackJack!!

		int[] cards = new int[N];
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}

		list = new ArrayList<>();

		comb(cards, visited, 0, N, 3, bj);

		int max = 0;
		for (int l : list) {
			if (max < l && l <= bj) {
				max = l;
			}
		}
		System.out.println(max);

	}

	static void comb(int[] cards, boolean[] visited, int start, int N, int r, int bj) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					sum += cards[i];
				}
			}

			if (sum == bj) {
				System.out.println(sum);
				System.exit(0);
			}

			list.add(sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(cards, visited, i + 1, N, r - 1, bj);
				visited[i] = false;
			}
		}
	}
}
