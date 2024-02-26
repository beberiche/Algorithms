package Q1891_사분면;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private long X, Y, pos[], size;
	private int N;
	private String D, ans = "-1";

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(ans);
	}


	private void solve() {
		size = (long) Math.sqrt(Math.pow(4, N));
		go(0, size - 1, 0, size - 1, 0, new StringBuilder());
		pos[0] -= Y;
		pos[1] += X;

		if (pos[0] < 0 || pos[1] < 0 || pos[0] >= size || pos[1] >= size) return;

		go2(0, size - 1, 0, size - 1, 0, new StringBuilder());
	}

	private void go2(long y1, long y2, long x1, long x2, int depth, StringBuilder sb) {
		if (depth > N) return;

		if (y1 > pos[0] || pos[0] > y2 || x1 > pos[1] || pos[1] > x2) return;

		if (y1 == y2 && x1 == x2) {
			ans = sb.toString();
			return;
		}


		long mid_y = (y1 + y2) / 2;
		long mid_x = (x1 + x2) / 2;

		go2(y1, mid_y, mid_x + 1, x2, depth + 1, new StringBuilder().append(sb).append(1));
		go2(y1, mid_y, x1, mid_x, depth + 1, new StringBuilder().append(sb).append(2));
		go2(mid_y + 1, y2, x1, mid_x, depth + 1, new StringBuilder().append(sb).append(3));
		go2(mid_y + 1, y2, mid_x + 1, x2, depth + 1, new StringBuilder().append(sb).append(4));
	}

	private void go(long y1, long y2, long x1, long x2, int depth, StringBuilder sb) {
		if (depth > N) {
			return;
		}

		if (depth > 0 && D.charAt(depth - 1) != sb.charAt(depth - 1)) {
			return;
		}


		if (y1 == y2 && x1 == x2) {
			pos = new long[]{y1, x1};
			return;
		}


		long mid_y = (y1 + y2) / 2;
		long mid_x = (x1 + x2) / 2;

		go(y1, mid_y, mid_x + 1, x2, depth + 1, new StringBuilder().append(sb).append(1));
		go(y1, mid_y, x1, mid_x, depth + 1, new StringBuilder().append(sb).append(2));
		go(mid_y + 1, y2, x1, mid_x, depth + 1, new StringBuilder().append(sb).append(3));
		go(mid_y + 1, y2, mid_x + 1, x2, depth + 1, new StringBuilder().append(sb).append(4));
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		D = stk.nextToken();
		stk = new StringTokenizer(br.readLine());
		X = Long.parseLong(stk.nextToken());
		Y = Long.parseLong(stk.nextToken());
	}
}
