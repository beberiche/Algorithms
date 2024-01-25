package Q20313_출퇴근;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private int N, M, A, B, K, magics[][];
	private long dist[][], ans;
	private List<Node> list[];

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
		dist = new long[K + 1][N + 1];
		for (int i = 0; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = Long.MAX_VALUE;
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Long.compare(n1.cost, n2.cost));
		pq.add(new Node(0, A, 0, 0));
		dist[0][A] = 0;
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			int m = curr.m;
			long cost = curr.cost;
			int node = curr.node;

			if (node == B) {
				ans = cost;
				pq.clear();
				break;
			}

			if (dist[m][node] < cost) continue;

			for (Node next : list[node]) {
				for (int magicCnt = m; magicCnt <= K; magicCnt++) {
					if (dist[magicCnt][next.node] > magics[magicCnt][next.key] + cost) {
						dist[magicCnt][next.node] = magics[magicCnt][next.key] + cost;
						pq.add(new Node(next.key, next.node, dist[magicCnt][next.node], magicCnt));
					}
				}
			}
		}

	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int[] costs = new int[M];

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			costs[i] = dist;

			list[n1].add(new Node(i, n2, dist, 0));
			list[n2].add(new Node(i, n1, dist, 0));
		}

		K = Integer.parseInt(br.readLine());
		magics = new int[K + 1][M];

		for (int i = 0; i < M; i++) {
			magics[0][i] = costs[i];
		}

		for (int k = 1; k <= K; k++) {
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				magics[k][i] = Integer.parseInt(stk.nextToken());
			}
		}
	}

	class Node {
		// 키, 다음 노드, 이동거리, 마법횟수.
		int key, node, m;
		long cost;

		Node(int key, int node, long cost, int m) {
			this.key = key;
			this.node = node;
			this.cost = cost;
			this.m = m;
		}
	}
}
