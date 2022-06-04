package Q4012_요리사;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int[][] recipe;
	static int[] sel;
	static int R, N;
	static int[] p;
	static int minSynergy;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			recipe = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					recipe[i][j] = Integer.parseInt(temp[j]);
				}
			}

			minSynergy = Integer.MAX_VALUE;
			R = N / 2;
			p = new int[N];
			visited = new boolean[N];

			comb(0, 0);
			System.out.println("#" + t + " " + minSynergy);
		}
	}

	public static void comb(int idx, int cnt) {
		if (cnt == R) {
			// 시너지 값 계산
			int d1 = 0;
			int d2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						if (visited[i] && visited[j]) {
							d1 += recipe[i][j];
						} else if (!visited[i] && !visited[j]) {
							d2 += recipe[i][j];
						}
					}
				}
			}

			minSynergy = Math.min(minSynergy, Math.abs(d1 - d2));
			return;
		}

		for (int i = idx; i < N; i++) {
			visited[i] = true;
			comb(i + 1, cnt + 1);
			visited[i] = false;
		}
	}
}
