package Q1289_원재의메모리복구하기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1289.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			char[] S = sc.next().toCharArray();

			int len = S.length;
			StringBuilder sb = new StringBuilder();
			while (--len >= 0) {
				sb.append(0);
			}

			char[] init = sb.toString().toCharArray();

			int cnt = 0;
			for (int i = 0; i < S.length; i++) {
				if (S[i] != init[i]) {
					int j = i;
					while (j < S.length) {
						init[j] = S[i];
						j++;
					}
					cnt++;
				}
			}

			System.out.printf("#%d %d\n", TC, cnt);
		}
	}
}
