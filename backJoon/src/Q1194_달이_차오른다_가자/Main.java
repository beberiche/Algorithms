package Q1194_달이_차오른다_가자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private char a[][];
	private int N, M, s[], ans;

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
		// r,c,열쇠,cnt
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{s[0], s[1], 0, 0});

		int bit = 1 << 6;
		boolean[][][] visited = new boolean[N][M][bit];
		visited[s[0]][s[1]][0] = true;

		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, -1, 0, 1};

		String key = "abcdef";
		String door = "ABCDEF";

		ans = -1;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (a[curr[0]][curr[1]] == '1') {
				ans = curr[3];
				q.clear();
				break;
			}


			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];


				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (a[nr][nc] == '#' || visited[nr][nc][curr[2]])
					continue;

				visited[nr][nc][curr[2]] = true;
				if (door.indexOf(a[nr][nc]) >= 0) {
					// 문인 경우
					int b = a[nr][nc] - 'A';
					if ((curr[2] & (1 << b)) != 0) {
						q.add(new int[]{nr, nc, curr[2], curr[3] + 1});
					}
				} else if (key.indexOf(a[nr][nc]) >= 0) {
					// 열쇠인 경우
					int b = a[nr][nc] - 'a';
					q.add(new int[]{nr, nc, curr[2] | (1 << b), curr[3] + 1});
				} else {
					// 0 혹은 1 혹은 .
					q.add(new int[]{nr, nc, curr[2], curr[3] + 1});
				}
			}
		}

	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		a = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				a[i][j] = str.charAt(j);
				if (a[i][j] == '0') {
					s = new int[]{i, j};
				}
			}
		}
	}
}
