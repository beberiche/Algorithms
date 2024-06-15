package Q22981_휴먼_파이프라인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		long K = Long.parseLong(stk.nextToken());

		long a[] = new long[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(stk.nextToken());
		}

		Arrays.sort(a);

		// idx가 기준 일 때, 0~idx / idx+1 ~ length 로 나누기
		long max = 0;
		for (int i = 0; i < N - 1; i++) {
			max = Math.max(max, a[0] * (i + 1) + a[i + 1] * (N - i - 1));
		}

		System.out.println((K % max == 0 ? K / max : K / max + 1));
	}
}
