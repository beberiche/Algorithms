package Q22865_가장_먼_곳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private List<Integer> f;
	private List<int[]> g[];
	private int N, M, ans;

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
		int[][] dist = new int[3][];
		int idx = 0;
		for (int n : f) {
			dist[idx++] = dijkstra(n);
		}

		int max = 0;
		ans = f.get(0);
		for (int i = 1; i <= N; i++) {
			int min = dist[0][i];
			for (int j = 1; j < 3; j++) {
				if (min > dist[j][i]) {
					min = dist[j][i];
				}
			}
			if (max < min) {
				max = min;
				ans = i;
			}
		}
	}

	private int[] dijkstra(int node) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		pq.add(new int[]{node, 0});

		int[] dist = new int[N + 1];
		Arrays.fill(dist, (int) 1e9 + 4);
		dist[node] = 0;


		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (int next[] : g[curr[0]]) {
				if (dist[next[0]] > curr[1] + next[1]) {
					dist[next[0]] = curr[1] + next[1];
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}


		return dist;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		f = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			f.add(Integer.parseInt(stk.nextToken()));
		}

		M = Integer.parseInt(br.readLine());
		g = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			g[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			g[n1].add(new int[]{n2, dist});
			g[n2].add(new int[]{n1, dist});
		}
	}
}
