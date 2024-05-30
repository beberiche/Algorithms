package Q1826_연료_채우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] a = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(stk.nextToken());
			a[i][1] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(a, (n1, n2) -> n1[0] - n2[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(stk.nextToken());
		int P = Integer.parseInt(stk.nextToken());

		int idx = 0;
		int cnt = 0;
		while (P < L) {
			while (idx < N && a[idx][0] <= P) {
				pq.add(a[idx++][1]);
			}
			if (pq.isEmpty()) {
				cnt = -1;
				break;
			}

			P += pq.poll();
			cnt++;
		}

		System.out.println(cnt);
	}
}
