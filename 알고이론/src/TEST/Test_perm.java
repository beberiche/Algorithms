package TEST;

import java.util.Arrays;
import java.util.Scanner;

public class Test_perm {
	static int[] arr = new int[] { 1, 2, 3, 4, 5 };
	static int[] sel;
	static boolean[] visited;
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		sel = new int[R];
		N = arr.length;
		R = sel.length;
		visited = new boolean[N];
		perm(0);

	}

	public static void perm(int idx) {
		if (idx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				sel[idx] = arr[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}
}
