package Q19623_회의실_배정_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int N, a[][], dp[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(dp[N - 1]);
	}

	private void solve() {
		Arrays.sort(a, (n1, n2) -> n1[1] - n2[1]);
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			int idx = binarySearch(i);
			int ret1 = idx == -1 ? a[i][2] : dp[idx] + a[i][2];
			int ret2 = i > 0 ? dp[i - 1] : 0;
			dp[i] = Math.max(ret1, ret2);
		}
	}

	private int binarySearch(int idx) {
		int l = 0;
		int r = idx;
		while (l < r) {
			int mid = (l + r) / 2;
			if (a[mid][1] <= a[idx][0]) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return r-1;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		a = new int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());
			a[i] = new int[]{st, ed, dist};
		}
	}
}
