package Q3987_보이저_1호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private char a[][];
	private int N, M, start[], ans[], total;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		StringBuilder sb = new StringBuilder();
		if (ans[0] == 0) sb.append('U');
		else if (ans[0] == 1) sb.append('R');
		else if (ans[0] == 2) sb.append('L');
		else sb.append('D');

		sb.append("\n").append(ans[1] > total ? "Voyager" : ans[1]);

		System.out.print(sb.toString());
	}

	private void solve() {
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, 1, -1, 0};

		ans = new int[2];
		for (int d = 0; d < 4; d++) {
			int[] curr = new int[]{start[0], start[1]};
			int vect = d;
			int[][] visited = new int[N][M];
			int dist = 1;
			visited[curr[0]][curr[1]] = dist;
			while (visited[curr[0]][curr[1]] <= total) {
				int nr = curr[0] + dr[vect];
				int nc = curr[1] + dc[vect];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || a[nr][nc] == 'C') {
					break;
				}

				if (a[nr][nc] == '/') {
					vect = vect % 2 == 0 ? vect + 1 : vect - 1;
				} else if (a[nr][nc] == '\\') {
					vect = (vect + 2) % 4;
				}

				visited[nr][nc] = ++dist;
				curr[0] = nr;
				curr[1] = nc;
			}

			if (ans[1] < dist) {
				ans[0] = d;
				ans[1] = dist;
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		total = N * M * 2;
		a = new char[N][];

		for (int i = 0; i < N; i++) {
			a[i] = br.readLine().toCharArray();
		}
		stk = new StringTokenizer(br.readLine());
		start = new int[]{Integer.parseInt(stk.nextToken()) - 1, Integer.parseInt(stk.nextToken()) - 1};
	}
}
