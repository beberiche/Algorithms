package Q1938_통나무_옮기기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static class Wood {
		int[] st;
		int[] mid;
		int[] ed;
		boolean isHorizon;
		int move;

		Wood(int[] st, int[] mid, int[] ed, boolean isHorizon, int move) {
			this.st = st;
			this.mid = mid;
			this.ed = ed;
			this.isHorizon = isHorizon;
			this.move = move;
		}

		Wood() {
		}


	}

	private static int N;
	private static char[][] a;
	private static Queue<Wood> q;
	private static boolean[][][] visited;
	private static int[] dr = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] dc = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		a = new char[N][N];

		int idx_s = 0;
		int idx_e = 0;
		Wood w = new Wood();
		Wood goal = new Wood();
		for (int i = 0; i < N; i++) {
			a[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (a[i][j] == 'B') {
					switch (idx_s) {
						case 0:
							w.st = new int[]{i, j};
							break;
						case 1:
							w.mid = new int[]{i, j};
							break;
						default:
							w.ed = new int[]{i, j};
					}
					idx_s++;
				}
				if (a[i][j] == 'E') {
					switch (idx_e) {
						case 0:
							goal.st = new int[]{i, j};
							break;
						case 1:
							goal.mid = new int[]{i, j};
							break;
						default:
							goal.ed = new int[]{i, j};
					}
					idx_e++;
				}
			}
		}

		// 수평, 수직 확인
		check(w);
		check(goal);

		q = new LinkedList<>();
		int ans = 0;

		q.add(w);
		visited = new boolean[2][N][N];
		visited[w.isHorizon ? 0 : 1][w.mid[0]][w.mid[1]] = true;
		while (!q.isEmpty()) {
			Wood curr = q.poll();

			if (exit(curr, goal)) {
				ans = curr.move;
				break;
			}


			move_up(curr); // 위
			move_down(curr); // 아래
			move_left(curr); // 왼쪽
			move_right(curr); // 오른쪽
			rotate(curr);// 90도
		}

		System.out.println(ans);
	}


	private static void move_up(Wood curr) {
		int next_move_st = curr.st[0] - 1;
		int next_move_mid = curr.mid[0] - 1;
		int next_move_ed = curr.ed[0] - 1;

		if (next_move_st < 0) return;

		int[] next_st;
		int[] next_mid;
		int[] next_ed;
		if (curr.isHorizon) {
			if (a[next_move_st][curr.st[1]] == '1' || a[next_move_mid][curr.mid[1]] == '1' || a[next_move_ed][curr.ed[1]] == '1')
				return;
			if (visited[0][next_move_mid][curr.mid[1]]) return;

			visited[0][next_move_mid][curr.mid[1]] = true;

			next_st = new int[]{next_move_st, curr.st[1]};
			next_mid = new int[]{next_move_mid, curr.mid[1]};
			next_ed = new int[]{next_move_ed, curr.ed[1]};
		} else {
			if (a[next_move_st][curr.st[1]] == '1') return;
			if (visited[1][next_move_mid][curr.mid[1]]) return;

			visited[1][next_move_mid][curr.mid[1]] = true;

			next_st = new int[]{next_move_st, curr.st[1]};
			next_mid = curr.st;
			next_ed = curr.mid;
		}
		q.add(new Wood(next_st, next_mid, next_ed, curr.isHorizon, curr.move + 1));
	}


	private static void move_down(Wood curr) {
		int next_move_st = curr.st[0] + 1;
		int next_move_mid = curr.mid[0] + 1;
		int next_move_ed = curr.ed[0] + 1;

		if (next_move_ed >= N) return;

		int[] next_st;
		int[] next_mid;
		int[] next_ed;

		if (curr.isHorizon) {
			if (a[next_move_st][curr.st[1]] == '1' || a[next_move_mid][curr.mid[1]] == '1' || a[next_move_ed][curr.ed[1]] == '1')
				return;

			if (visited[0][next_move_mid][curr.mid[1]]) return;

			visited[0][next_move_mid][curr.mid[1]] = true;

			next_st = new int[]{next_move_st, curr.st[1]};
			next_mid = new int[]{next_move_mid, curr.mid[1]};
			next_ed = new int[]{next_move_ed, curr.ed[1]};
		} else {
			if (a[next_move_ed][curr.ed[1]] == '1') return;

			if (visited[1][next_move_mid][curr.mid[1]]) return;

			visited[1][next_move_mid][curr.mid[1]] = true;

			next_st = curr.mid;
			next_mid = curr.ed;
			next_ed = new int[]{next_move_ed, curr.ed[1]};
		}

		q.add(new Wood(next_st, next_mid, next_ed, curr.isHorizon, curr.move + 1));
	}

	private static void move_left(Wood curr) {
		int next_move_st = curr.st[1] - 1;
		int next_move_mid = curr.mid[1] - 1;
		int next_move_ed = curr.ed[1] - 1;

		if (next_move_st < 0) return;

		int[] next_st;
		int[] next_mid;
		int[] next_ed;

		if (curr.isHorizon) {
			if (a[curr.st[0]][next_move_st] == '1') return;

			if (visited[0][curr.mid[0]][next_move_mid]) return;

			visited[0][curr.mid[0]][next_move_mid] = true;

			next_st = new int[]{curr.st[0], next_move_st};
			next_mid = curr.st;
			next_ed = curr.mid;
		} else {
			if (a[curr.st[0]][next_move_st] == '1' || a[curr.mid[0]][next_move_mid] == '1' || a[curr.ed[0]][next_move_ed] == '1')
				return;

			if (visited[1][curr.mid[0]][next_move_mid]) return;

			visited[1][curr.mid[0]][next_move_mid] = true;

			next_st = new int[]{curr.st[0], next_move_st};
			next_mid = new int[]{curr.mid[0], next_move_mid};
			next_ed = new int[]{curr.ed[0], next_move_ed};
		}

		q.add(new Wood(next_st, next_mid, next_ed, curr.isHorizon, curr.move + 1));
	}

	private static void move_right(Wood curr) {
		int next_move_st = curr.st[1] + 1;
		int next_move_mid = curr.mid[1] + 1;
		int next_move_ed = curr.ed[1] + 1;

		if (next_move_ed >= N) return;

		int[] next_st;
		int[] next_mid;
		int[] next_ed;

		if (curr.isHorizon) {
			if (a[curr.st[0]][next_move_ed] == '1') return;

			if (visited[0][curr.mid[0]][next_move_mid]) return;

			visited[0][curr.mid[0]][next_move_mid] = true;

			next_st = curr.mid;
			next_mid = curr.ed;
			next_ed = new int[]{curr.ed[0], next_move_ed};
		} else {
			if (a[curr.st[0]][next_move_st] == '1' || a[curr.mid[0]][next_move_mid] == '1' || a[curr.ed[0]][next_move_ed] == '1')
				return;

			if (visited[1][curr.mid[0]][next_move_mid]) return;

			visited[1][curr.mid[0]][next_move_mid] = true;

			next_st = new int[]{curr.st[0], next_move_st};
			next_mid = new int[]{curr.mid[0], next_move_mid};
			next_ed = new int[]{curr.ed[0], next_move_ed};
		}

		q.add(new Wood(next_st, next_mid, next_ed, curr.isHorizon, curr.move + 1));
	}

	private static void rotate(Wood curr) {
		// 범위 확인
		for (int d = 0; d < 8; d++) {
			int nr = curr.mid[0] + dr[d];
			int nc = curr.mid[1] + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || a[nr][nc] == '1') return;
		}

		if (visited[curr.isHorizon ? 1 : 0][curr.mid[0]][curr.mid[1]]) return;

		visited[curr.isHorizon ? 1 : 0][curr.mid[0]][curr.mid[1]] = true;

		int[] next_st;
		int[] next_mid;
		int[] next_ed;

		// 회전 가능
		if (curr.isHorizon) { // 수평 시
			// 좌 => 상
			// 우 => 하
			next_st = new int[]{curr.st[0] - 1, curr.st[1] + 1};
			next_ed = new int[]{curr.ed[0] + 1, curr.ed[1] - 1};
		} else {
			// 상 => 좌
			// 하 => 우
			next_st = new int[]{curr.st[0] + 1, curr.st[1] - 1};
			next_ed = new int[]{curr.ed[0] - 1, curr.ed[1] + 1};
		}
		next_mid = curr.mid;

		q.add(new Wood(next_st, next_mid, next_ed, !curr.isHorizon, curr.move + 1));
	}

	private static boolean exit(Wood curr, Wood goal) {
		return curr.st[0] == goal.st[0] && curr.st[1] == goal.st[1] && curr.mid[0] == goal.mid[0] && curr.mid[1] == goal.mid[1] && curr.ed[0] == goal.ed[0] && curr.ed[1] == goal.ed[1];
	}

	private static void check(Wood wood) {
		if (wood.st[0] == wood.ed[0]) wood.isHorizon = true;
	}
}
