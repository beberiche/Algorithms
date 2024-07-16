package Q1041_주사위;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long sum = 0;
		long max = 0;
		long a[] = new long[6];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			a[i] = Long.parseLong(stk.nextToken());
			sum += a[i];
			max = Math.max(max, a[i]);
		}

		if (N == 1) {
			System.out.println(sum - max);
			return;
		}


		long n1 = Long.MAX_VALUE;
		long n2 = Long.MAX_VALUE;
		long n3 = Long.MAX_VALUE;
		for (int i = 0; i < 6; i++) {
			n1 = Math.min(a[i], n1);
			for (int j = i + 1; j < 6; j++) {
				if (i + j == 5) continue;
				n2 = Math.min(a[i] + a[j], n2);
				for (int k = j + 1; k < 6; k++) {
					if (i + k == 5 || j + k == 5) continue;
					n3 = Math.min(a[i] + a[j] + a[k], n3);
				}
			}
		}


		long result = (4L * n3) + ((8L * N - 12) * n2) + (5L * N - 6) * (N - 2) * n1;
		System.out.println(result);
	}
}
