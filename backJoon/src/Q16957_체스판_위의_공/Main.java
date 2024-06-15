package Q16957_체스판_위의_공;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int R, C, a[][], ret[][], p[][];
	private int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	private int[] dc = {-1, 1, 0, -1, 1, -1, 1, 0};

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(ret[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private void solve() {
		ret = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				bfs(i, j);
			}
		}
	}

	private void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{i, j});
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			// 8방향 중 가장 작은 수 확인
			int[] next = check(curr);

			// 8방향 중 갈 곳이 없다면 종료
			if (next == curr) {
				ret[curr[0]][curr[1]]++;
				break;
			}

			// 8방향 중 최솟값 가운데, 이미 대표값이 있는 곳이라면?
			p[curr[0]][curr[1]] = find(next);
			q.add(new int[]{p[curr[0]][curr[1]] / C, p[curr[0]][curr[1]] % C});
		}
	}

	private int find(int[] node) {
		if (node[0] * C + node[1] == p[node[0]][node[1]]) return p[node[0]][node[1]];
		return p[node[0]][node[1]] = find(new int[]{p[node[0]][node[1]] / C, p[node[0]][node[1]] % C});
	}

	private int[] check(int[] pos) {
		int[] min = pos;
		for (int d = 0; d < 8; d++) {
			int nr = pos[0] + dr[d];
			int nc = pos[1] + dc[d];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C || a[min[0]][min[1]] < a[nr][nc]) continue;

			min = new int[]{nr, nc};
		}
		return min;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());

		a = new int[R][C];
		p = new int[R][C];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				p[i][j] = idx++;
			}
		}
	}
}
