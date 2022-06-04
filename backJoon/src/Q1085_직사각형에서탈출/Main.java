package Q1085_직사각형에서탈출;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		int result = Integer.MAX_VALUE;
		result = Math.min(result, Math.abs(0 - x));
		result = Math.min(result, Math.abs(0 - y));
		result = Math.min(result, w - x);
		result = Math.min(result, h - y);
		System.out.println(result);
	}
}
