package Q5569_출근_경로;

import java.util.Scanner;

public class Main {
	private int w, h, dp[][][][];
	private int dr[] = {1, 0};
	private int dc[] = {0, 1};
	private static int ret, MOD;

	public static void main(String[] args) {
		Main m = new Main();
		m.input();
		ret += m.solve(1, 1, 0, 0);
		ret += m.solve(1, 1, 0, 1);
		System.out.println(ret % MOD);
	}


	private int solve(int r, int c, int rotate, int dir) {
		if (r < 1 || c < 1 || r > h || c > w) {
			return 0;
		}
		if (r == h && c == w) {
			return 1;
		}

		if (dp[rotate][dir][r][c] != -1) {
			return dp[rotate][dir][r][c];
		}

		dp[rotate][dir][r][c] = 0;

		if (dir == 0) {
			dp[rotate][dir][r][c] += rotate == 0 ?
					solve(r + 1, c, 1, dir) :
					solve(r + 1, c, 1, dir) + solve(r, c + 1, 0, dir == 1 ? 0 : 1);

		} else {
			dp[rotate][dir][r][c] += rotate == 0 ?
					solve(r, c + 1, 1, dir) :
					solve(r, c + 1, 1, dir) + solve(r + 1, c, 0, dir == 1 ? 0 : 1);

		}

		return dp[rotate][dir][r][c] %= MOD;
	}

	private void input() {
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt();
		h = sc.nextInt();
		dp = new int[2][2][h + 1][w + 1];
		MOD = 100000;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 1; k <= h; k++) {
					for (int l = 1; l <= w; l++) {
						dp[i][j][k][l] = -1;
					}
				}
			}
		}
	}
}
