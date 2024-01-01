package Q18114_블랙_프라이데이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		C = Integer.parseInt(stk.nextToken());
		arr = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(arr);
		int ans = go();
		System.out.println(ans);
	}


	private static int bs(int left, int right, int val) {
		int l = left;
		int r = right;
		while (l <= r) {
			int mid = (l + r) / 2;
			int sum = val + arr[mid];
			if (sum == C) return 1;
			else if (sum < C) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return 0;
	}

	private static int go() {
		// 1개인 경우
		if (bs(0, N - 1, 0) > 0) return 1;

		// 2개인 경우
		for (int i = 0; i < N; i++) {
			if (bs(i + 1, N - 1, arr[i]) > 0) return 1;
		}

		// 3개인 경우
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (bs(j + 1, N - 1, arr[i] + arr[j]) > 0) return 1;
			}
		}

		return 0;
	}
}
