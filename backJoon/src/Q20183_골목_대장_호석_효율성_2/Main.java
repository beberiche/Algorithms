package Q20183_골목_대장_호석_효율성_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M, A, B;
	private long C, ans;
	private List<Node> list[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans == (int) 1e9 + 1 ? -1 : ans);
	}

	private void solve() {
		int l = 1;
		int r = (int) 1e9 + 1;

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
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(A, 0));

		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[A] = 0;
		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (dist[curr.num] < curr.dist) continue;

			if (curr.num == B) {
				return dist[curr.num] <= C;
			}

			for (Node next : list[curr.num]) {
				if (next.dist > mid) continue;

				if (dist[next.num] > curr.dist + next.dist) {
					dist[next.num] = curr.dist + next.dist;
					pq.add(new Node(next.num, dist[next.num]));
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
		C = Long.parseLong(stk.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			list[n1].add(new Node(n2, dist));
			list[n2].add(new Node(n1, dist));
		}
	}

	private class Node implements Comparable<Node> {
		int num;
		long dist;

		Node(int num, long dist) {
			this.num = num;
			this.dist = dist;
		}


		@Override
		public int compareTo(Node o) {
			return Long.compare(this.dist, o.dist);
		}
	}
}