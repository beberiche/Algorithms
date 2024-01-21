package Q27501_RGB_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	private int N, a[][];
	private long dp[][];
	private boolean visited[];
	private List<Integer> list[];
	private long ret;
	private char[] tmp;
	private StringBuilder sb;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ret);
		System.out.println(sb.toString());
	}

	private void solve() {
		go(1);
		ret = Math.max(dp[1][0], Math.max(dp[1][1], dp[1][2]));
		tmp = new char[N + 1];
		find(1, ret == dp[1][0] ? 0 : ret == dp[1][1] ? 1 : 2);
		sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(tmp[i]);
		}
	}

	private void find(int curr, int rgb) {
		tmp[curr] = rgb == 0 ? 'R' : rgb == 1 ? 'G' : 'B';
		visited[curr] = false;

		for (int next : list[curr]) {
			if (!visited[next]) continue;

			if (rgb == 0) {
				find(next, dp[next][1] > dp[next][2] ? 1 : 2);
			} else if (rgb == 1) {
				find(next, dp[next][0] > dp[next][2] ? 0 : 2);
			} else if (rgb == 2) {
				find(next, dp[next][0] > dp[next][1] ? 0 : 1);
			}
		}

	}


	private void go(int curr) {
		visited[curr] = true;

		dp[curr][0] = a[curr][0];
		dp[curr][1] = a[curr][1];
		dp[curr][2] = a[curr][2];

		for (int next : list[curr]) {
			if (visited[next]) continue;
			go(next);
			dp[curr][0] += Math.max(dp[next][1], dp[next][2]);
			dp[curr][1] += Math.max(dp[next][0], dp[next][2]);
			dp[curr][2] += Math.max(dp[next][0], dp[next][1]);
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			list[n1].add(n2);
			list[n2].add(n1);
		}

		a = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int g = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			a[i][0] = r;
			a[i][1] = g;
			a[i][2] = b;
		}


		dp = new long[N + 1][3];
		visited = new boolean[N + 1];
	}
}
