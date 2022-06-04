package Q1292_쉽게푸는문제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= 300; i++) {
			for (int j = 0; j < i; j++) {
				list.add(i);
			}
		}

		int st = sc.nextInt() - 1;
		int ed = sc.nextInt();
		int sum = 0;
		for (int i = st; i < ed; i++) {
			sum += list.get(i);
		}
		System.out.println(sum);

	}
}
