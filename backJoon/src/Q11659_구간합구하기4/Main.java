package Q11659_구간합구하기4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 수의 갯수
		int M = sc.nextInt(); // 합을 구해야하는 갯수

		int[] arr = new int[N + 1];
		arr[1] = sc.nextInt();
		for (int i = 2; i <= N; i++)
			arr[i] = arr[i - 1] + sc.nextInt();

		StringBuilder sb = new StringBuilder();
		while (--M >= 0)
			sb.append(-1 * arr[sc.nextInt() - 1] + arr[sc.nextInt()]).append("\n");

		System.out.println(sb.toString());
	}
}
