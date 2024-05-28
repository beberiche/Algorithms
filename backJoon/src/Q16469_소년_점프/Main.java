package Q16469_소년_점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, a[][], visited[][][];
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());

		a = new int[R][C];
		visited = new int[R][C][3];
		for (int i = 0; i < R; i++) {
			char[] ch_arr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				a[i][j] = ch_arr[j] - '0';
				Arrays.fill(visited[i][j], -1);
			}
		}

		for (int i = 0; i < 3; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken())-1;
			int n2 = Integer.parseInt(stk.nextToken())-1;
			bfs(n1, n2, i);
		}

		int cnt = -1;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j][0] >= 0 && visited[i][j][1] >= 0 && visited[i][j][2] >= 0) {
					int ret = Math.max(visited[i][j][0], Math.max(visited[i][j][1], visited[i][j][2]));

					if (ans > ret) {
						ans = ret;
						cnt = 1;
					} else if(ans == ret) {
						cnt++;
					}
				}
			}
		}

		if (cnt == -1) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
		System.out.println(cnt);
	}

	private static void bfs(int r, int c, int k) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r, c, 0});
		visited[r][c][k] = 0;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || a[nr][nc] != 0 || visited[nr][nc][k] != -1) {
					continue;
				}

				visited[nr][nc][k] = curr[2] + 1;
				q.add(new int[]{nr, nc, visited[nr][nc][k]});
			}
		}

	}
}
