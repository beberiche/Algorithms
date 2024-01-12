package Q17265_나의_인생에는_수학과_함께;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int N, dp_min[][], dp_max[][];
	private char a[][];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(dp_max[N - 1][N - 1] + " " + dp_min[N - 1][N - 1]);
	}

	private void solve() {
		dp_min = new int[N][N];
		dp_max = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp_min[i], Integer.MAX_VALUE);
			Arrays.fill(dp_max[i], Integer.MIN_VALUE);
		}

		dp_min[0][0] = a[0][0] - '0';
		dp_max[0][0] = a[0][0] - '0';


		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (a[r][c] != '+' && a[r][c] != '+' && a[r][c] != '-') {
					// 위에서 오는 경우
					if (r - 2 >= 0) {
						dp_min[r][c] = calc(dp_min[r - 2][c], a[r - 1][c], a[r][c] - '0');
						dp_max[r][c] = calc(dp_max[r - 2][c], a[r - 1][c], a[r][c] - '0');
					}
					// 왼쪽에서 오는 경우
					if (c - 2 >= 0) {
						dp_min[r][c] = Math.min(dp_min[r][c], calc(dp_min[r][c - 2], a[r][c - 1], a[r][c] - '0'));
						dp_max[r][c] = Math.max(dp_max[r][c], calc(dp_max[r][c - 2], a[r][c - 1], a[r][c] - '0'));
					}
					// 대각선의 경우
					if (r - 1 >= 0 && c - 1 >= 0) {
						int ret_min = Math.min(calc(dp_min[r - 1][c - 1], a[r][c - 1], a[r][c] - '0'),
								calc(dp_min[r - 1][c - 1], a[r - 1][c], a[r][c] - '0'));
						int ret_max = Math.max(calc(dp_max[r - 1][c - 1], a[r][c - 1], a[r][c] - '0'),
								calc(dp_max[r - 1][c - 1], a[r - 1][c], a[r][c] - '0'));
						dp_min[r][c] = Math.min(dp_min[r][c], ret_min);
						dp_max[r][c] = Math.max(dp_max[r][c], ret_max);
					}
				}
			}
		}
	}

	private int calc(int prev, char cal, int curr) {
		if (cal == '+') {
			return prev + curr;
		} else if (cal == '-') {
			return prev - curr;
		} else {
			return prev * curr;
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new char[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[i][j] = stk.nextToken().charAt(0);
			}
		}
	}
}
