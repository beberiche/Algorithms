package Q15664_N과_M_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int a[], b[];
	private static boolean visited[];
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		a = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		b = new int[M];
		Arrays.sort(a);
		visited = new boolean[N];
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

		int prev = -1;
		for (int i = 0; i < a.length; i++) {
			if (visited[i] || prev == a[i]) continue;

			if (d == 0 || (d > 0 && b[d - 1] <= a[i])) {
				prev = a[i];
				visited[i] = true;
				b[d] = a[i];
				perm(d + 1);
				visited[i] = false;
			}
		}
	}

}
