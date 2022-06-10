package Q2567_싸이클;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int P = sc.nextInt();

		System.out.println(recur(0,N, N, P, 0));
	}

	private static int recur(int d,int num, int n, int p, int len) {
		if (num == 1) {
			return len += 1;
		}
		if (num == 0) {
			return 1;
		}

		return recur(d+1,num * n % p, n, p, len + 1);
	}
}
