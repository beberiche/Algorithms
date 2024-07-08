package Q15665_N과_M_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int a[], b[];
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		a = new int[N];
		b = new int[M];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(a);
		sb = new StringBuilder();
		perm(0);
		System.out.print(sb.toString());
	}

	private static void perm(int d) {
		if (d >= b.length) {
			for(int num : b) sb.append(num).append(" ");
			sb.append("\n");
			return;
		}

		int prev = 0;
		for (int i = 0; i < a.length; i++) {
			if(prev != a[i]) {
				prev = a[i];
				b[d] = a[i];
				perm(d + 1);
			}
		}
	}
}
