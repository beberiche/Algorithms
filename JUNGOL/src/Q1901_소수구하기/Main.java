package Q1901_소수구하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		while (--N >= 0) {
			int num = sc.nextInt();
			int diff = 0;
			while (true) {
				boolean m = check(num - diff);
				boolean p = check(num + diff);
				if (diff == 0 && m && p) {
					System.out.println(num);
					break;
				} else if (m && p) {
					System.out.println((num - diff) + " " + (num + diff));
					break;
				} else if (m) {
					System.out.println(num - diff);
					break;
				} else if (p) {
					System.out.println(num + diff);
					break;
				} else
					diff++;
			}

		}
	}

	private static boolean check(int n) {
		// TODO Auto-generated method stub
		for (int i = 2; i <= (int) Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}

}
