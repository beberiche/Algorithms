package Q9657_돌_게임_3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(N % 7 == 0 || N % 7 == 2 ? "CY" : "SK");
	}
}
