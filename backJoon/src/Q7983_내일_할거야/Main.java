package Q7983_내일_할거야;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int range = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());

			pq.add(new int[]{end - range + 1, end});
		}

		int[] curr = pq.poll();
		int st = curr[0];
		while (!pq.isEmpty()) {
			int[] next = pq.poll();
			if (next[1] < st) {
				st = next[0];
				continue;
			}

			int diff = next[1] - st + 1;

			st = next[0] - diff;
		}

		System.out.println(st - 1);
	}
}
