package Q4883_삼각_그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;

			int[][] a = new int[N][3];
			for (int i = 0; i < N; i++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					a[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			a[0][0] = 1000000;
			a[0][2] += a[0][1];

			for (int i = 1; i < N; i++) {
				a[i][0] = Math.min(a[i - 1][0], a[i - 1][1]) + a[i][0];
				a[i][1] = Math.min(Math.min(a[i - 1][0], a[i][0]), Math.min(a[i - 1][1], a[i - 1][2])) + a[i][1];
				a[i][2] = Math.min(a[i - 1][1], Math.min(a[i - 1][2], a[i][1])) + a[i][2];
			}

			sb.append(t++).append(". ").append(a[N - 1][1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
