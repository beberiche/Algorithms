package Q15655_N과M6;

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
		comb(0, 0);
		System.out.print(sb.toString());
	}

	public static void comb(int cnt, int idx) {
		if (cnt == R) {
			for (int s : sel) {
				sb.append(s).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			sel[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}
	}
}