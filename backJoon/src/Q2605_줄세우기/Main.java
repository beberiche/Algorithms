package Q2605_줄세우기;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> list = new LinkedList<>();

		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			list.add(sc.nextInt(), i);
		}

		for (int i = N - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
	}
}
