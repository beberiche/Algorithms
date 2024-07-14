package Q9658_돌_게임_4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(N % 7 == 1 || N % 7 == 3 ? "CY" : "SK");
	}
}