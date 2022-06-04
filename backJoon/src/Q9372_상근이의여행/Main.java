package Q9372_상근이의여행;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (--T > -1) {
			int N = sc.nextInt(); // 국가의 수
			int M = sc.nextInt(); // 비행기 수

			for (int i = 0; i < M; i++) {
				sc.nextInt();
				sc.nextInt();
			}
			System.out.println(N - 1);
		}
	}
}
