package Q1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	static int P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int TC = 1; TC <= 10; TC++) {
			sc.nextInt();
			int N = sc.nextInt();
			P = sc.nextInt();
			System.out.println("#" + TC + " " + recur(N, 1));
		}
	}

	public static int recur(int N, int mul) {
		if (mul == P) {
			return N;
		}
		return N * recur(N, mul + 1);
	}
}
