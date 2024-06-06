package Q20182_골목_대장_호석_효율성_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M, A, B, C, INF = (int) 1e9, ans;
	private List<int[]> list[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans == 21 ? -1 : ans);
	}

	private void solve() {
		int l = 1;
		int r = 21;

		while (l < r) {
			int mid = (l + r) / 2;
			if (go(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		ans = r;
	}

	private boolean go(int mid) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		ans = INF;
		pq.add(new int[]{A, 0});

		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[A] = 0;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (curr[0] == B) {
				return dist[curr[0]] <= C;
			}

			for (int[] next : list[curr[0]]) {
				if (next[1] > mid) continue;

				if (dist[next[0]] > curr[1] + next[1]) {
					dist[next[0]] = curr[1] + next[1];
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}

		return false;
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

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			list[n1].add(new int[]{n2, dist});
			list[n2].add(new int[]{n1, dist});
		}
	}
}