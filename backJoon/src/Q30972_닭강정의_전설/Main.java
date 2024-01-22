package Q30972_닭강정의_전설;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private StringBuilder sb = new StringBuilder();
	private int sum[][];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() throws Exception {
		int Q = Integer.parseInt(br.readLine());
		while (--Q >= 0) {
			stk = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(stk.nextToken());
			int c1 = Integer.parseInt(stk.nextToken());
			int r2 = Integer.parseInt(stk.nextToken());
			int c2 = Integer.parseInt(stk.nextToken());

			int ret1 = sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1 - 1][c1 - 1];
			int ret2 = sum[r2 - 1][c2 - 1] - sum[r1][c2 - 1] - sum[r2 - 1][c1] + sum[r1][c1];

			sb.append(2 * ret2 - ret1).append("\n");
		}
	}

	private void input() throws Exception {

		int N = Integer.parseInt(br.readLine());
		sum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(stk.nextToken());
			}
		}
	}
}
