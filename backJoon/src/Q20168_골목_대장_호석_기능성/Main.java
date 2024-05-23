package Q20168_골목_대장_호석_기능성;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M, A, B, C, ans = -1, INF = (int) 1e9;
	private List<int[]> list[];
	private boolean[] visited;

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
		int l = 1;
		int r = 1000;

		while (l < r) {
			int mid = (l + r) / 2;
			if (go(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		ans = r == 1001 ? -1 : r;
	}

	private boolean go(int cost) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		pq.add(new int[]{A, 0});
		dist[A] = 0;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (curr[1] > C) continue;

			for (int[] next : list[curr[0]]) {
				if (next[1] > cost) continue;

				if (dist[next[0]] > curr[1] + next[1]) {
					dist[next[0]] = curr[1] + next[1];
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}

		return dist[B] <= C;
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			list[a].add(new int[]{b, c});
			list[b].add(new int[]{a, c});
		}
	}
}
