package Q17087_숨바꼭질_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int S = Integer.parseInt(stk.nextToken());

		int[] a = new int[N];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Math.abs(Integer.parseInt(stk.nextToken()) - S);
		}

		int ret = a[0];
		for (int i = 1; i < N; i++) {
			ret = gcd(ret, a[i]);
		}
		System.out.println(ret);
	}

	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}
