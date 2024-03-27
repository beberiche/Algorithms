package Q7453_합이_0인_네_정수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, a[][], ab[];
	private long ans;

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
		ab = new int[N * N];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ab[idx++] = a[i][0] + a[j][1];
			}
		}

		Arrays.sort(ab);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cd = a[i][2] + a[j][3];
				ans += upperBound(-cd) - lowerBound(-cd);
			}
		}
	}

	private int lowerBound(int val) {
		int l = 0;
		int r = N * N - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (ab[mid] >= val) {
				r = mid - 1;
			} else
				l = mid + 1;
		}
		return r;
	}

	private int upperBound(int val) {
		int l = 0;
		int r = N * N - 1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (ab[mid] > val) {
				r = mid - 1;
			} else
				l = mid + 1;
		}
		return r;
	}

	// 입력값 받기
	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		a = new int[N][4];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(stk.nextToken());
			a[i][1] = Integer.parseInt(stk.nextToken());
			a[i][2] = Integer.parseInt(stk.nextToken());
			a[i][3] = Integer.parseInt(stk.nextToken());
		}
	}

}
