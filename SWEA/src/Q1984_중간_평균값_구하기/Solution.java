package Q1984_중간_평균값_구하기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1984.txt"));
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int T = 1; T <= TC; T++) {
			int[] arr = new int[10];
			int min = 10000, max = -1, sum = 0;
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
				min = Math.min(min, arr[i]);
				max = Math.max(max, arr[i]);
				sum += arr[i];
			}
			System.out.printf("#%d %.0f\n", T, (sum - max - min) / 8d);
		}
	}
}
