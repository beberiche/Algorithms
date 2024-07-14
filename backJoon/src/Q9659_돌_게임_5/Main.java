package Q9659_돌_게임_5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		System.out.println(N % 2 == 0 ? "CY" : "SK");
	}
}
