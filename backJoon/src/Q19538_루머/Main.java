package Q19538_루머;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, start[], ret[], neighbor[];
	private List<Integer> list[];
	private StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() {
		ret = new int[N + 1];
		Arrays.fill(ret, -1);
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < start.length; i++) {
			q.add(new int[]{start[i], 0});
			ret[start[i]] = 0;
		}
		neighbor = new int[N + 1];

		while (!q.isEmpty()) {
			int[] curr = q.poll();


			for (Integer next : list[curr[0]]) {
				neighbor[next]++;
				if (ret[next] != -1) continue;

				if (neighbor[next] * 2 >= list[next].size()) {
					ret[next] = curr[1] + 1;
					q.add(new int[]{next, curr[1] + 1});
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(ret[i]).append(" ");
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int num;
			while ((num = Integer.parseInt(stk.nextToken())) != 0) {
				list[i].add(num);
			}
		}

		int M = Integer.parseInt(br.readLine());
		start = new int[M];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			start[i] = Integer.parseInt(stk.nextToken());
		}
	}
}
