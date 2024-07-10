package Q1850_최대공약수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();

		long ret = GCD(Math.max(A, B), Math.min(A, B));
		StringBuilder sb = new StringBuilder();

		while(--ret>=0) sb.append(1);

		System.out.print(sb.toString());
	}

	private static long GCD(long a, long b) {
		if (b == 0) return a;
		return GCD(b, a % b);
	}
}
