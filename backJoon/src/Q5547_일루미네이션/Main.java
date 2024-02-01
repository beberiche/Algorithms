package Q5547_일루미네이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int W, H, a[][], ans;
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
		Queue<int[]> q = new LinkedList<>();

		int[] dr = {-1, -1, 0, 0, 1, 1};
		int[] even_dc = {-1, 0, -1, 1, -1, 0};
		int[] odd_dc = {0, 1, -1, 1, 1, 0};

		boolean visited[][] = new boolean[H + 2][W + 2];
		q.add(new int[]{0, 0});
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 6; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[0] % 2 == 0 ? curr[1] + even_dc[d] : curr[1] + odd_dc[d];

				if (nr < 0 || nc < 0 || nr >= H + 2 || nc >= W + 2 || visited[nr][nc]) continue;

				if (a[nr][nc] == 1) {
					ans++;
				} else {
					visited[nr][nc] = true;
					q.add(new int[]{nr, nc});
				}
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		W = Integer.parseInt(stk.nextToken());
		H = Integer.parseInt(stk.nextToken());

		a = new int[H + 2][W + 2];

		for (int i = 1; i <= H; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= W; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}
