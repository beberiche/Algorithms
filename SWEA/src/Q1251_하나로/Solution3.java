package Q1251_하나로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int node;
	double dist;

	public Edge(int node, double dist) {
		this.node = node;
		this.dist = dist;
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.dist, o.dist);
	}
}

public class Solution3 {

	private int N;
	private double dist[][], E, INF = Double.MAX_VALUE;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static long ans;

	public static void main(String[] args) throws Exception {
		Solution3 s = new Solution3();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			s.input();
			s.solve();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		s.output();
	}

	private void output() {
		System.out.println(sb.toString());
	}

	private void solve() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i < N; i++) {
			pq.add(new Edge(i, dist[0][i]));
		}

		boolean visited[] = new boolean[N];
		visited[0] = true;
		int cnt = 1;
		double sum = 0;
		while (cnt < N) {
			Edge e = pq.poll();
			if (visited[e.node]) continue;
			visited[e.node] = true;
			sum += e.dist;
			cnt++;
			for (int n = 0; n < N; n++) {
				pq.add(new Edge(n, dist[e.node][n]));
			}
		}

		ans = Math.round(sum * E);
	}


	private void input() throws Exception {
		N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][2];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i][0] = Integer.parseInt(stk.nextToken());
		}

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i][1] = Integer.parseInt(stk.nextToken());
		}


		dist = new double[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j || dist[i][j] > 0) continue;
				double d = Math.pow(a[i][0] - a[j][0], 2) + Math.pow(a[i][1] - a[j][1], 2);
				dist[i][j] = d;
				dist[j][i] = d;
			}
		}

		E = Double.parseDouble(br.readLine());
	}
}
