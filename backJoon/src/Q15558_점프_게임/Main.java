package Q15558_점프_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int N, K, a[][], ans;

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
		q.add(new int[]{0, 0, 0});
		boolean visited[][] = new boolean[2][N + K];
		visited[0][0] = true;

		ans = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[1] >= N) {
				ans = 1;
				break;
			}

			// 위로
			if (a[curr[0]][curr[1] + 1] == 1 && !visited[curr[0]][curr[1] + 1]) {
				visited[curr[0]][curr[1] + 1] = true;
				q.add(new int[]{curr[0], curr[1] + 1, curr[2] + 1});
			}

			// 아래로
			if (curr[1] - 1 > 0 && a[curr[0]][curr[1] - 1] == 1 && !visited[curr[0]][curr[1] - 1] && curr[1] - 1 > curr[2]) {
				visited[curr[0]][curr[1] - 1] = true;
				q.add(new int[]{curr[0], curr[1] - 1, curr[2] + 1});
			}

			// 다른 즐로 이동
			int nr = (curr[0] + 1) % 2;
			int nc = curr[1] + K;
			if (a[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				q.add(new int[]{nr, nc, curr[2] + 1});
			}
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());

		a = new int[2][N + K];

		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
			for (int j = N; j < N + K; j++) {
				a[i][j] = 1;
			}
		}
	}
}
