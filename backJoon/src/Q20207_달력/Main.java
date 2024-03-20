package Q20207_달력;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int ans = 0;
	private int[] cnt;

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
		int row = 0;
		int col = 0;
		for (int i = 1; i < cnt.length; i++) {
			if (cnt[i] == 0) {
				ans += row * col;
				row = 0;
				col = 0;
			} else {
				row = Math.max(row, cnt[i]);
				col++;
			}
		}
		ans += row * col;
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cnt = new int[366];
		while (--N >= 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			for (int i = st; i <= ed; i++) {
				cnt[i]++;
			}
		}
	}
}
