package Q2285_우체국;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][2];

		long mid = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(stk.nextToken());
			a[i][1] = Integer.parseInt(stk.nextToken());
			mid += a[i][1];
		}
		mid /= 2;
		long sum = 0;
		Arrays.sort(a, (n1, n2) -> n1[0] - n2[0]);
		for (int i = 0; i < N; i++) {
			sum += a[i][1];
			if (sum >= mid) {
				System.out.println(a[i][0]);
				break;
			}
		}
	}
}
