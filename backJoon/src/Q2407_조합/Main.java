package Q2407_조합;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		BigInteger n1 = new BigInteger(String.valueOf(1));
		BigInteger n2 = new BigInteger(String.valueOf(1));
		for (int i = 0; i < m; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		System.out.println(n1.divide(n2));
	}
}
