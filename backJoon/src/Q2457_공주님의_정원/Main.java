package Q2457_공주님의_정원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int N, a[][], ans = 0;

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
		int st = 301;
		int ed = 1201;
		int st_idx = 0;
		int ed_max = 0;
		int cnt = 0;
		while (st < ed) {
			boolean check = false;
			for (int i = st_idx; i < N; i++) {
				if (a[i][0] > st) break;

				if (ed_max < a[i][1]) {
					check = true;
					ed_max = a[i][1];
					st_idx = i + 1;
				}
			}

			if (check) {
				st = ed_max;
				cnt++;
			} else {
				break;
			}
		}
		ans = cnt;
		if (ed_max < ed) ans = 0;
	}


	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			int[] arr = new int[]{Integer.parseInt(stk.nextToken()) * 100 + Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()) * 100 + Integer.parseInt(stk.nextToken())};
			a[i] = arr;
		}

		Arrays.sort(a, (n1, n2) ->  n1[0] - n2[0]);

	}
}
