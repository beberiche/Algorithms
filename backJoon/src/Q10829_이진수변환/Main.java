package Q10829_이진수변환;

import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		decToBin(new Scanner(System.in).nextLong());
		System.out.print(sb.reverse().toString());
	}

	private static void decToBin(long s) {
		if (s == 0)
			return;
		sb.append(s % 2);
		decToBin(s / 2);
	}
}
