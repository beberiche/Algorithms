package Q12978_스크루지_민호_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private List<Integer> t[];
	private int N, dp[][], ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private void solve() {
		go(1, -1);
		ans = Math.min(dp[0][1], dp[1][1]);
	}

	private void go(int curr, int prev) {
		dp[0][curr] = 0;
		dp[1][curr] = 1;

		for (int next : t[curr]) {
			if (prev != next) {
				go(next, curr);
				dp[1][curr] += Math.min(dp[0][next], dp[1][next]);
				dp[0][curr] += dp[1][next];
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		t = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			t[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			t[n1].add(n2);
			t[n2].add(n1);
		}

		dp = new int[2][N + 1];
	}
}
