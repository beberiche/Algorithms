package Q10610_30;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();

		char[] digits = N.toCharArray();
		Arrays.sort(digits);

		if (digits[0] != '0') {
			System.out.println(-1);
			return;
		}

		int sum = 0;
		for (char digit : digits) {
			sum += digit - '0';
		}

		if (sum % 3 != 0) {
			System.out.println(-1);
			return;
		}

		StringBuilder largestNumber = new StringBuilder(new String(digits));
		largestNumber.reverse();
		System.out.println(largestNumber.toString());
	}
}
