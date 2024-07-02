package Q2580_스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static boolean row[][], col[][], square3x3[][];
	private static int N, a[][];
	private static List<int[]> zero;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		a = new int[N][N];

		row = new boolean[N][N + 1];
		col = new boolean[N][N + 1];
		square3x3 = new boolean[N][N + 1];

		zero = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				if (a[i][j] != 0) {
					row[i][a[i][j]] = true;
					col[j][a[i][j]] = true;
					square3x3[i / 3 * 3 + j / 3][a[i][j]] = true;
				} else {
					zero.add(new int[]{i, j});
				}
			}
		}

		go(0);
	}

	private static void go(int idx) {
		if (idx >= zero.size()) {
			print();
			System.exit(0);
		}


		int[] curr = zero.get(idx);
		for (int i = 1; i <= N; i++) {
			if (check(curr, i)) {
				update(curr, i);
				go(idx + 1);
				reset(curr, i);
			}
		}
	}



	private static boolean check(int[] curr, int num) {
		return !row[curr[0]][num] && !col[curr[1]][num] && !square3x3[curr[0] / 3 * 3 + curr[1] / 3][
				num];
	}

	private static void update(int[] curr, int num) {
		row[curr[0]][num] = true;
		col[curr[1]][num] = true;
		square3x3[curr[0] / 3 * 3 + curr[1] / 3][num] = true;
		a[curr[0]][curr[1]] = num;
	}

	private static void reset(int[] curr, int num) {
		row[curr[0]][num] = false;
		col[curr[1]][num] = false;
		square3x3[curr[0] / 3 * 3 + curr[1] / 3][num] = false;
		a[curr[0]][curr[1]] = 0;
	}


	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(a[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}