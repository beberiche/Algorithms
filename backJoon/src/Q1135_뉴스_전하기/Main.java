package Q1135_뉴스_전하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, dp[];
	private List<Integer> list[];

	private static int ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		ans = m.solve(0);
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private int solve(int curr) {
		for (int n : list[curr]) {
			dp[n] = solve(n);
		}

		Collections.sort(list[curr], (n1, n2) -> dp[n2] - dp[n1]);
		int ret = 0;
		for (int i = 0; i < list[curr].size(); i++) {
			int num = list[curr].get(i);
			dp[num] += i + 1;
			ret = Math.max(ret, dp[num]);
		}
		return ret;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(stk.nextToken());
			if (p == -1) continue;
			list[p].add(i);
		}

		dp= new int[N];
	}
}
