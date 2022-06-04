package TEST;

import java.util.Arrays;
import java.util.Scanner;

public class Test_comb {
	static int[] arr = new int[] { 1, 2, 3, 4, 5 };
	static int[] sel;
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		sel = new int[R];
		N = arr.length;
		R = sel.length;
		comb(0, 0);
	}

	public static void comb(int idx, int sidx) {
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		if (idx == N) {
			return;
		}

		sel[sidx] = arr[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}
