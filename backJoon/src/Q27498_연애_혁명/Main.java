package Q27498_연애_혁명;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int p[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		p = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
			if (n2[3] == n1[3]) return n2[2] - n1[2];
			return n2[3] - n1[3];
		});
		int sum = 0;
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int love = Integer.parseInt(stk.nextToken());
			int achieve = Integer.parseInt(stk.nextToken());

			pq.add(new int[]{n1, n2, love, achieve});
			sum += love;
		}

		int cnt = 0;
		int used = 0;
		while (!pq.isEmpty() && cnt < N - 1) {
			int[] curr = pq.poll();

			int x = find(curr[0]);
			int y = find(curr[1]);

			if (x != y) {
				cnt++;
				p[y] = x;
				used += curr[2];
			}
		}

		System.out.println(sum - used);
	}

	private static int find(int node) {
		if (node == p[node]) return node;
		return p[node] = find(p[node]);
	}
}
