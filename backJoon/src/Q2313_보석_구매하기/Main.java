package Q2313_보석_구매하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long total_sum = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int L = Integer.parseInt(br.readLine());
			int[] a = new int[L+1];
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= L; j++) {
				a[j] = Integer.parseInt(stk.nextToken());
			}

			int curr_sum = 0, max_sum = Integer.MIN_VALUE;
			int l = 1, r = 1;
			int ll = l, rr = r;
			while (r <= L) {
				curr_sum += a[r++];
				if (curr_sum > max_sum || (curr_sum == max_sum && rr - ll + 1 > r - l)) {
					max_sum = curr_sum;
					ll = l;
					rr = r-1;
				}

				if (curr_sum <= 0) {
					curr_sum = 0;
					l = r;
				}
			}

			total_sum += max_sum;
			sb.append(ll).append(" ").append(rr).append("\n");
		}

		System.out.println(total_sum);
		System.out.print(sb.toString());
	}
}
