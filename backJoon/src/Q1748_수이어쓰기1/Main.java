package Q1748_수이어쓰기1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int len = (N + "").length();

		int st = 9;
		int sum = 0;
		int min = 1;
		for (int i = 1; i <= len - 1; i++) {
			sum += i * st;
			st *= 10;
			min *= 10;
		}

		sum += (N - min + 1) * len;
		System.out.println(sum);
	}
}
