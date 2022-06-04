package Q9934_완전이진트리;

import java.util.Scanner;

public class Main {
	static int K;
	static int[] arr;
	static StringBuilder[] sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();

		arr = new int[(int) Math.pow(2, K) - 1];

		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();

		sb = new StringBuilder[K];

		for (int i = 0; i < K; i++) {
			sb[i] = new StringBuilder();
		}

		recur(0, arr.length - 1, 0);

		for (StringBuilder s : sb)
			System.out.println(s);

	}

	public static void recur(int st, int e, int d) {
		if (d == K)
			return;
		int mid = (st + e) / 2;

		sb[d].append(arr[mid] + " ");

		recur(st, mid - 1, d + 1);
		recur(mid + 1, e, d + 1);
	}

}