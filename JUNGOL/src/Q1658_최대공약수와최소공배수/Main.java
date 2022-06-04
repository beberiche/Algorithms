package Q1658_최대공약수와최소공배수;

import java.util.Scanner;

public class Main {
	static int gcd;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		GCD(n1, n2, 1);
		int lcm = n1 * n2 / gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}

	private static void GCD(int n1, int n2, int cnt) {
		if (n1 % cnt == 0 && n2 % cnt == 0)
			gcd = cnt;

		if (cnt <= n1 && cnt <= n2)
			GCD(n1, n2, cnt + 1);
	}
}
