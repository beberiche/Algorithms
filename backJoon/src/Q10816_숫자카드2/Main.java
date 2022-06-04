package Q10816_숫자카드2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (--M >= 0) {
			int n = sc.nextInt();
			sb.append(upperBound(n) - lowerBound(n)).append(" ");
		}

		System.out.println(sb.toString());

	}

	public static int lowerBound(int n) {
		int st, ed, mid;

		st = 0;
		ed = arr.length;

		while (ed > st) {
			mid = (st + ed) / 2;
			if (arr[mid] >= n) {
				ed = mid;
			} else {
				st = mid + 1;
			}
		}

		return ed;

	}

	private static int upperBound(int n) {
		int st, ed, mid;

		st = 0;
		ed = arr.length;

		while (ed > st) {
			mid = (st + ed) / 2;
			if (arr[mid] > n) {
				ed = mid;
			} else {
				st = mid + 1;
			}
		}

		return ed;

	}
}
