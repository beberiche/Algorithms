package Q1983_조교의성적매기기;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1983.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();
			int order = sc.nextInt();

			double[] students = new double[N + 1];
			for (int i = 1; i <= N; i++) {
				double n1 = sc.nextInt() * 0.35;
				double n2 = sc.nextInt() * 0.45;
				double n3 = sc.nextInt() * 0.2;
				students[i] = n1 + n2 + n3;
			}

			double score = students[order];

			for (int i = 1; i <= N; i++) {
				int minIdx = i;
				for (int j = 1; j <= N; j++) {
					if (students[minIdx] > students[j]) {
						minIdx = j;
					}
					double temp = students[i];
					students[i] = students[minIdx];
					students[minIdx] = temp;
				}
			}

			double idx = 1;
			for (int i = 1; i <= N; i++) {
				if (score == students[i]) {
					idx = i;
					break;
				}
			}

			System.out.printf("#%d %s\n", TC, grade[(int) Math.ceil(idx / (N / 10)) - 1]);
		}
	}
}
