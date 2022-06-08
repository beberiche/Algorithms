package Q1161_하노이1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		hanoi(1, 3, 2, new Scanner(System.in).nextInt());
	}

	private static void hanoi(int from, int to, int through, int n) {
		// TODO Auto-generated method stub

		if (n == 0)
			return;

		hanoi(from, through, to, n - 1);
		System.out.println(n + " : " + from + " -> " + to);
		hanoi(through, to, from, n - 1);
	}
}
