package Q14907_프로젝트_스케줄링;

import java.util.*;
import java.io.*;

public class Main {
	private int cost[], inDegree[], ans;
	private List<Integer> list[];

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
		Queue<int[]> q = new LinkedList<>();
		ans = 0;
		int dp[] = new int[inDegree.length];
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0 && cost[i] != 0) {
				dp[i] = cost[i];
				q.add(new int[]{i, dp[i]});
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (list[curr[0]].size() == 0) ans = Math.max(ans, dp[curr[0]]);
			for (int next : list[curr[0]]) {
				inDegree[next]--;
				dp[next] = Math.max(dp[next], cost[next] + curr[1]);
				if (inDegree[next] == 0) {
					q.add(new int[]{next, dp[next]});
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;

		int size = 26;
		cost = new int[size];
		inDegree = new int[size];
		list = new ArrayList[size];
		for (int i = 0; i < size; i++) {
			list[i] = new ArrayList<>();
		}

		while ((str = br.readLine()) != null) {
			StringTokenizer stk = new StringTokenizer(str);
			char child = stk.nextToken().charAt(0);
			int t = Integer.parseInt(stk.nextToken());
			String parent = null;
			if (stk.hasMoreTokens()) {
				parent = stk.nextToken();
			}

			cost[child - 'A'] = t;
			if (parent != null) {
				inDegree[child - 'A'] += parent.length();
				for (int i = 0; i < parent.length(); i++) {
					char p = parent.charAt(i);
					list[p - 'A'].add(child - 'A');
				}
			}
		}
	}
}

