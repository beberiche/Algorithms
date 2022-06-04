package Q1009_각자리수의역과합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int num = sc.nextInt();
			if (num <= 0)
				break;

			String iToS = num + "";
			int mul = 1;
			int sum = 0;
			int rev = 0;
			for (int i =0; i < iToS.length(); i++) {
				int temp = iToS.charAt(i) - '0';
				sum += temp;
				rev += (temp * mul);
				mul *= 10;
			}
			System.out.println(rev + " " + sum);
		}
	}
}
