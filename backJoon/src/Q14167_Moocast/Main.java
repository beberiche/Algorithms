package Q14167_Moocast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private List<int[]> list;
	private int p[], N, ans;

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
		Collections.sort(list, (n1, n2) -> n1[2] - n2[2]);

		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] curr = list.get(i);
			int x = find(curr[0]);
			int y = find(curr[1]);

			if (x != y) {
				if (x < y) p[y] = x;
				else p[x] = y;
				if (++cnt == N - 1) {
					ans = curr[2];
					break;
				}
			}
		}
	}

	private int find(int n) {
		if (p[n] == n) return n;
		return p[n] = find(p[n]);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] pos = new int[N][2];
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			pos[i] = new int[]{r, c};
		}

		list = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int[] n1 = pos[i];
				int[] n2 = pos[j];
				int dist = (int) (Math.pow(Math.abs(n1[0] - n2[0]), 2) + Math.pow(Math.abs(n1[1] - n2[1]), 2));
				list.add(new int[]{i, j, dist});
			}
		}
	}
}
