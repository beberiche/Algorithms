package Q1633_최고의_팀_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	int idx, a[][], dp[][][];
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		ans = m.solve(0, 0, 0);
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private int solve(int i, int w, int b) {
		if (i >= idx) {
			return 0;
		}

		if (dp[i][w][b] != 0) {
			return dp[i][w][b];
		}

		int ret = solve(i + 1, w, b);
		if (w < 15) ret = Math.max(ret, solve(i + 1, w + 1, b) + a[i][0]);
		if (b < 15) ret = Math.max(ret, solve(i + 1, w, b + 1) + a[i][1]);


		return dp[i][w][b] = ret;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = new int[1001][2];

		String str;
		StringTokenizer stk;
		idx = 0;
		while ((str = br.readLine()) != null && !str.isEmpty()) {
			stk = new StringTokenizer(str);
			a[idx][0] = Integer.parseInt(stk.nextToken());
			a[idx++][1] = Integer.parseInt(stk.nextToken());
		}

		dp = new int[idx][16][16];
	}
}
