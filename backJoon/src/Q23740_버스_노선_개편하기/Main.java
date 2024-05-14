package Q23740_버스_노선_개편하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int a[][];
	private List<int[]> list;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (int[] ret : list) {
			sb.append(ret[0]).append(" ").append(ret[1]).append(" ").append(ret[2]).append("\n");
		}
		System.out.print(sb.toString());
	}

	private void solve() {
		Arrays.sort(a, (n1, n2) -> n1[0] - n2[0]);

		int st = a[0][0];
		int ed = a[0][1];
		int cost = a[0][2];

		list = new ArrayList<>();
		for (int i = 1; i < a.length; i++) {
			int[] curr = a[i];
			if (ed < curr[0]) {
				// 안 겹치는 경우
				list.add(new int[]{st, ed, cost});
				st = curr[0];
				ed = curr[1];
				cost = curr[2];
			} else {
				// 겹치는 경우
				ed = Math.max(ed, curr[1]);
				cost = Math.min(cost, curr[2]);
			}
		}
		list.add(new int[]{st, ed, cost});
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(stk.nextToken());
			a[i][1] = Integer.parseInt(stk.nextToken());
			a[i][2] = Integer.parseInt(stk.nextToken());
		}
	}
}