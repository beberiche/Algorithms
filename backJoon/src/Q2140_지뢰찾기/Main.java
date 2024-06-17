package Q2140_지뢰찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private int N, ans;
	private char a[][];
	private List<int[]> list;

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
		int dr[] = {-1, -1, -1, 0, 1, 1, 1, 0};
		int dc[] = {-1, 0, 1, 1, 1, 0, -1, -1};

		for (int[] pos : list) {
			boolean zero = false;
			for (int d = 0; d < dr.length; d++) {
				int nr = pos[0] + dr[d];
				int nc = pos[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

				if (a[nr][nc] == '0') {
					zero = true;
					a[pos[0]][pos[1]] = 'X';
					break;
				}
			}

			if (!zero) {
				for (int d = 0; d < dr.length; d++) {
					int nr = pos[0] + dr[d];
					int nc = pos[1] + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N || a[nr][nc] == '#' || a[nr][nc] == 'X' || a[nr][nc] == 'B')
						continue;

					char cnt = (char) ((int) a[nr][nc] - 1);
					a[nr][nc] = cnt;
				}
				a[pos[0]][pos[1]] = 'B';
				ans++;
			}
		}

	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		a = new char[N][N];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				a[i][j] = str.charAt(j);
				if (a[i][j] == '#') list.add(new int[]{i, j});
			}
		}
	}
}
