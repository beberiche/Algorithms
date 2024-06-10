package Q23254_나는_기말고사형_인간이야;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[] a = new int[M];
		stk = new StringTokenizer(br.readLine());

		int sum =0;
		for (int i = 0; i < M; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			sum += a[i];
		}

		stk = new StringTokenizer(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);

		for (int i = 0; i < M; i++) {
			pq.add(new int[]{i, Math.min(Integer.parseInt(stk.nextToken()), 100 - a[i])});
		}

		int time = 24 * N;

		while (!pq.isEmpty() && time != 0) {
			int[] curr = pq.poll();

			a[curr[0]] += curr[1];
			sum += curr[1];
			if (a[curr[0]] < 100) {
				pq.add(new int[]{curr[0], Math.min(curr[1], 100 - a[curr[0]])});
			}
			time--;
		}

		System.out.println(sum);
	}
}
