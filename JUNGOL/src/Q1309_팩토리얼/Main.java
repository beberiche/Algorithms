package Q1309_팩토리얼;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println(recur(new Scanner(System.in).nextInt()));
	}

	private static long recur(int n) {
		// TODO Auto-generated method stub
		if (n <= 1) {
			System.out.println("1! = 1");
			return n;
		} else {
			System.out.println(n + "! = " + n + " * " + (n - 1) + "!");
			return recur(n-1) * n;
		}
	}

}
