package Q16509_장군;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int R = 10, C = 9, a[], b[], ans = -1;

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
		Queue<int[]> q = new LinkedList();
		boolean visited[][] = new boolean[R][C];

		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int[] ddr = {-1, -1, -1, 1, 1, 1, 1, -1};
		int[] ddc = {-1, 1, 1, 1, 1, -1, -1, -1};

		visited[a[0]][a[1]] = true;
		q.add(new int[]{a[0], a[1], 0});
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == b[0] && curr[1] == b[1]) {
				ans = curr[2];
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if (nr == b[0] && nc == b[1]) continue;

				boolean check = true;
				for (int dd = d * 2; dd < d * 2 + 2; dd++) {
					int nnr = nr;
					int nnc = nc;
					for (int ddd = 0; ddd < 2; ddd++) {
						nnr += ddr[dd];
						nnc += ddc[dd];

						if (ddd == 0 && nnr == b[0] && nnc == b[1]) {
							check = false;
							break;
						}
					}

					if (!check || nnr < 0 || nnc < 0 || nnr >= R || nnc >= C || visited[nnr][nnc])
						continue;
					visited[nnr][nnc] = true;
					q.add(new int[]{nnr, nnc, curr[2] + 1});
				}

			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = new int[2];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		b = new int[2];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			b[i] = Integer.parseInt(stk.nextToken());
		}
	}
}
