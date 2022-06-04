package Q1247_최적경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] se; // 회사와 집의 좌표
	static int[][] customers; // 고객의 좌표
	static int[][] sel;
	static boolean[] visited;
	static int N;
	static int ans = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T <= TC; T++) {
			N = Integer.parseInt(br.readLine()); // 고객의 수
			se = new int[2][2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			se[0][0] = Integer.parseInt(st.nextToken()); // 회사 좌표 r
			se[0][1] = Integer.parseInt(st.nextToken()); // 회사 좌표 c
			se[1][0] = Integer.parseInt(st.nextToken()); // 집 좌표 r
			se[1][1] = Integer.parseInt(st.nextToken()); // 집 좌표 c

			customers = new int[N][2];
			sel = new int[N][2];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					customers[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			ans = 1000000;
			perm(0);
			System.out.println("#" + T + " " + ans);
		}
	}

	static void perm(int idx) {
		if (idx == N) {
			ans = Math.min(ans, dist());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			sel[idx] = customers[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	static int dist() {
		int temp = Math.abs(se[0][0] - sel[0][0]) + Math.abs(se[0][1] - sel[0][1]); // 회사와 고객 1과의 거리
		for (int i = 0; i < N - 1; i++) {
			temp += Math.abs(sel[i][0] - sel[i + 1][0]) + Math.abs(sel[i][1] - sel[i + 1][1]); // 고객 1~N까지의 거리
		}
		return temp += Math.abs(se[1][0] - sel[N - 1][0]) + Math.abs(se[1][1] - sel[N - 1][1]); // 고객 N과 집까지
	}
}
