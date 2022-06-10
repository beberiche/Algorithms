package Q1175_주사위던지기2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		recur(0, N, M, 0, "");
	}

	private static void recur(int d, int n, int m, int sum, String ans) {
		// TODO Auto-generated method stub
		if (d == n) {
			if (sum == m) {
				System.out.println(ans);
			}
			return;
		}

		if (sum > m) {
			return;
		}

		for (int i = 1; i <= 6; i++) {
			recur(d + 1, n, m, sum + i, ans + i + " ");
		}
	}

}
