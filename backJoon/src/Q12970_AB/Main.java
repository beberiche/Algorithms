package Q12970_AB;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int maxK = N / 2 * (N - N / 2);
		if (maxK < K) {
			System.out.println(-1);
			return;
		}

		int A_cnt = N % 2 == 0 ? N / 2 : N / 2 + 1;
		int B_cnt = N / 2;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < A_cnt; i++) {
			sb.append('A');
		}

		for (int i = 0; i < B_cnt; i++) {
			sb.append('B');
		}

		int idx = A_cnt;

		while (maxK > K) {
			if (maxK - A_cnt >= K) {
				sb.replace(idx - A_cnt, idx - A_cnt + 1, "B");
				maxK -= A_cnt;
			} else {
				sb.replace(idx - (maxK - K), idx - (maxK - K) + 1, "B");
				maxK -= (maxK - K);
			}
			sb.replace(idx, idx + 1, "A");
			idx++;
		}

		System.out.println(sb.toString());

	}
}
