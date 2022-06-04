package Q1740_소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int min = 0;
	static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		if (check(N, M)) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

	private static boolean check(int n, int m) {
		// TODO Auto-generated method stub
		List<Integer> pnList = new ArrayList<>();
		for (int i = n; i <= m; i++) {
			boolean c = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					c = false;
					break;
				}
			}
			if (c)
				pnList.add(i);
		}

		if (pnList.size() == 0)
			return false;
		else {
			min = pnList.get(0);
			if(min==1) {
				min = 2;
				sum -= 1;
			}
			
			for (int a : pnList)
				sum += a;
			return true;
		}
	}
}
