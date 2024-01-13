package Q1525_퍼즐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private Map<String, Integer> m;

	private Queue<String> q;
	private int ans = -1, N;

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
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};
		String goal = "123456780";
		while (!q.isEmpty()) {
			String map = q.poll();
			if (map.equals(goal)) {
				ans = m.get(goal);
				q.clear();
				break;
			}
			int idx0 = map.indexOf('0');
			for (int d = 0; d < 4; d++) {
				int nr = idx0 / 3 + dr[d];
				int nc = idx0 % 3 + dc[d];

				if (nr < 0 || nc < 0 || nr >= 3 || nc >= 3) continue;

				int nextIdx = N * nr + nc;

				StringBuilder sb = new StringBuilder(map);
				char nextCh = sb.charAt(nextIdx);
				sb.setCharAt(idx0, nextCh);
				sb.setCharAt(nextIdx, '0');

				String nextMap = sb.toString();
				if (!m.containsKey(nextMap)) {
					q.add(nextMap);
					m.put(nextMap, m.get(map) + 1);
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 3;
		q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(stk.nextToken());
				sb.append(num);
			}
		}

		m = new HashMap<>();
		m.put(sb.toString(), 0);
		q.add(sb.toString());
	}
}
