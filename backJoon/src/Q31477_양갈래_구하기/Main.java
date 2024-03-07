package Q31477_양갈래_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private List<int[]> list[];
	private int N, dp[], INF = (int) 1e7 + 4, ans;

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
//		dp = new int[N + 1];
//		Arrays.fill(dp, -1);
		ans = go(1, -1);
	}

	private int go(int node, int p) {
		int ret = 0;
		for (int[] child : list[node]) {
			if (child[0] == p) continue;
			ret += Math.min(child[1], go(child[0], node));
		}

		if (ret == 0) ret = INF;
		return ret;
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
			int dist = Integer.parseInt(stk.nextToken());

			list[n1].add(new int[]{n2, dist});
			list[n2].add(new int[]{n1, dist});
		}
	}
}
