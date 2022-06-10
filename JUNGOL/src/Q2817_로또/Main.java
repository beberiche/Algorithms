package Q2817_로또;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] sel = new int[6];
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		comb(0, 0);
	}

	private static void comb(int cnt, int idx) {
		if (cnt == 6) {
			for (int n : sel)
				System.out.print(n + " ");
			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			sel[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}

}
