package Q29726_숏코딩의_왕_브실이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		int[] a = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		int l = 0;
		int r = N - M - 1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while (r < N) {
			min = Math.min(min, a[l++]);
			max = Math.max(max, a[r++] - min);
		}
		System.out.println(max);
	}
}
