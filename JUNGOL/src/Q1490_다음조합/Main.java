package Q1490_다음조합;

import java.util.Scanner;

public class Main {
	static int[] arr, sel, find;
	static int N, K;
	static boolean check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		K = sc.nextInt();
		sel = new int[K];
		find = new int[K];
		for (int i = 0; i < K; i++)
			find[i] = sc.nextInt();

		comb(0, 0);
		System.out.println("NONE");
	}

	private static void comb(int idx, int d) {
		// TODO Auto-generated method stub
		if (d == K) {
			if (check) {
				for (int n : sel)
					System.out.print(n + " ");
				System.exit(0);
			} else {
				int temp = 1;
				for (int i = 0; i < K; i++) {
					if (sel[i] != find[i]) {
						temp = 0;
						break;
					}
				}
				if (temp == 1)
					check = true;
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			sel[d] = arr[i];
			comb(i + 1, d + 1);
		}
	}

}
