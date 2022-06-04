package Q16992_로마숫자만들기;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static final int[] arr = new int[] { 1, 5, 10, 50 };
	static Set<Integer> set = new HashSet<>();
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		comb(0, 0, 0);
		System.out.println(set.size());
	}

	static void comb(int idx, int sidx, int sum) {
		if (sidx == N) {
			set.add(sum);
			return;
		}

		for (int i = idx; i < 4; i++)
			comb(i, sidx + 1, sum + arr[i]);
	}
}
