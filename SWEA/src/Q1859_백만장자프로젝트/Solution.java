package Q1859_백만장자프로젝트;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1859.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			long ans = 0;
			int max = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < max) {
					ans += max - arr[i];
				} else {
					max = arr[i];
				}
			}

			System.out.printf("#%d %d\n", TC, ans);

		}
	}
}
