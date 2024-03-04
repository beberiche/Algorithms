package Q2643_색종이_올려_놓기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, a[][];
	private List<int[]> list;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(list.size());
	}

	private void solve() {
		Arrays.sort(a, (n1, n2) -> {
			if (n2[1] == n1[1]) return n2[0] - n1[0];
			return n2[1] - n1[1];
		});

		list = new ArrayList<>();
		list.add(a[0]);

		for (int i = 1; i < N; i++) {
			if (check(i, list.size() - 1)) {
				list.add(a[i]);
			} else {
				int idx = binarySearch(i);
				list.set(idx, a[i]);
			}
		}
	}

	private int binarySearch(int idx) {
		int l = 0;
		int r = list.size();

		while (l < r) {
			int mid = (l + r) / 2;
			if (!check(idx, mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}

	private boolean check(int i, int j) {
		if (list.get(j)[0] >= a[i][0] && list.get(j)[1] >= a[i][1]) return true;
		return false;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());

			if (x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			a[i] = new int[]{x, y};
		}

	}
}
