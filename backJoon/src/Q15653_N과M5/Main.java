package Q15653_N과M5;

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
			if ((visited & (1 << i)) == 0) {
				sel[cnt] = arr[i];
				perm(cnt + 1, visited | 1 << i);
			}
		}
	}
}