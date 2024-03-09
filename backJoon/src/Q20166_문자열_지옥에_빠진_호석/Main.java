package Q20166_문자열_지옥에_빠진_호석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, M, K;
	private char a[][];
	private int dr[] = {-1, 0, 1, 0, 1, 1, -1, -1};
	private int dc[] = {0, -1, 0, 1, 1, -1, 1, -1};
	private Map<String, Integer> m;
	private String g_strs[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			sb.append(m.get(g_strs[i])).append("\n");
		}
		System.out.print(sb.toString());
	}

	private void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bfs(i, j);
			}
		}
	}

	private void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c, String.valueOf(a[r][c])));

		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (m.containsKey(curr.str)) {
				m.put(curr.str, m.get(curr.str) + 1);
			}

			if (curr.str.length() >= 5) continue;


			for (int d = 0; d < dr.length; d++) {
				int nr = (curr.r + dr[d]) % N;
				int nc = (curr.c + dc[d]) % M;
				if (nr < 0) nr = N - 1;
				if (nc < 0) nc = M - 1;

				q.add(new Node(nr, nc, curr.str + a[nr][nc]));
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		a = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				a[i][j] = str.charAt(j);
			}
		}

		m = new HashMap<>();
		g_strs = new String[K];
		for (int i = 0; i < K; i++) {
			String str = br.readLine();
			g_strs[i] = str;
			m.put(str, 0);
		}
	}

	private class Node {
		int r, c;
		String str;

		Node(int r, int c, String str) {
			this.r = r;
			this.c = c;
			this.str = str;
		}
	}
}
