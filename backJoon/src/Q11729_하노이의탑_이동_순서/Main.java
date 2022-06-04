package Q11729_하노이의탑_이동_순서;

import java.util.Scanner;

public class Main {
//	static StringBuilder sb = new StringBuilder();
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt();
//
//		System.out.println((int) Math.pow(2, N) - 1);
//		hanoi(N, 1, 2, 3);
//		System.out.println(sb.toString());
//	}
//
//	static void hanoi(int N, int departure, int via, int arrive) {
//		if (N == 0) {
//			return;
//		}
//		hanoi(N - 1, departure, arrive, via);
//		sb.append(departure + " " + arrive + "\n");
//		hanoi(N - 1, via, departure, arrive);
//	}
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();

		sb.append((int) Math.pow(2, N) - 1 + "\n");
		recur(N, 1, 2, 3);
		System.out.println(sb.toString());
	}

	static void recur(int N, int from, int temp, int to) {
		if (N == 0)
			return;

		recur(N - 1, from, to, temp);
		sb.append(from + " " + to + "\n");
		recur(N - 1, temp, from, to);

	}
}
