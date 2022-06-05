package Q20187_종이접기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int[][] pierce1 = { { 0, 1, 2, 3 }, { 1, 0, 3, 2 }, { 2, 3, 0, 1 },
			{ 3, 2, 1, 0 } };
	static final int[][] pierce2 = { { 2, 3, 0, 1 }, { 3, 2, 1, 0 }, { 0, 1, 2, 3 },
			{ 1, 0, 3, 2 } }; // D
	static final int[][] pierce3 = { { 1, 0, 3, 2 }, { 0, 1, 2, 3 }, { 3, 2, 1, 0 },
			{ 2, 3, 0, 1 } }; // R
	static final int[][] pierce4 = { { 3, 2, 1, 0 }, { 2, 3, 0, 1 }, { 1, 0, 3, 2 },
			{ 0, 1, 2, 3 } }; // D&&R

	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = (int) Math.pow(2, Integer.parseInt(br.readLine()));

		arr = new int[k][k];

		String str = br.readLine();
		int n = Integer.parseInt(br.readLine());

		// 1, 2, 3, 4
		// 수직 0 0 1 1
		// 수평 0 1 0 1
		int horizon = 0;
		int vertical = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'U') {
				horizon = 0;
			} else if (str.charAt(i) == 'D') {
				horizon = 1;
			} else if (str.charAt(i) == 'L') {
				vertical = 0;
			} else if (str.charAt(i) == 'R') {
				vertical = 1;
			}
		}

		if (horizon == 1 && vertical == 1) {
			pierceArr(pierce4, k, n);
		} else if (vertical == 1) {
			pierceArr(pierce3, k, n);
		} else if (horizon == 1) {
			pierceArr(pierce2, k, n);
		} else {
			pierceArr(pierce1, k, n);
		}
	}

	private static void pierceArr(int[][] pierce, int k, int n) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0)
						sb.append(pierce[n][0] + " ");
					else
						sb.append(pierce[n][1] + " ");
				} else {
					if (j % 2 == 0)
						sb.append(pierce[n][2] + " ");
					else
						sb.append(pierce[n][3] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
