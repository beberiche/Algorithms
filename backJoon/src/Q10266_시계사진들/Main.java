package Q10266_시계사진들;

import java.util.Scanner;

public class Main {
	static final int len = 360000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] clockA = new int[len * 2];
		int[] clockB = new int[len];

		for (int i = 0; i < N; i++) {
			int idx = sc.nextInt();
			clockA[idx] = 1;
			clockA[idx + len] = 1;
		}

		for (int i = 0; i < N; i++) {
			clockB[sc.nextInt()] = 1;
		}

		System.out.println(KMP(clockA, clockB));

	}

	public static String KMP(int[] parent, int[] pattern) {
		int table[] = makeTable(pattern);
		int j = 0;
		for (int i = 0; i < len * 2; i++) {
			while (j > 0 && parent[i] != pattern[j]) {
				j = table[j - 1];
			}
			if (parent[i] == pattern[j]) {
				if (j == len - 1) {
					return "possible";
				}
				j++;
			}
		}
		return "impossible";
	}

	public static int[] makeTable(int[] pattern) {
		int[] table = new int[len];
		int j = 0;
		for (int i = 1; i < len; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = table[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				table[i] = ++j;
			}
		}
		return table;
	}
}
