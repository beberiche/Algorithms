package Q15656_N과M7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int R;

	static int[] arr;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		sel = new int[R];
		perm(0, 0);
		System.out.print(sb.toString());
	}

	public static void perm(int cnt, int visited) {
		if (cnt == R) {
			for (int s : sel) {
				sb.append(s).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			sel[cnt] = arr[i];
			perm(cnt + 1, i);
		}
	}
}