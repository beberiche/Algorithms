package Q17612_쇼핑몰;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			q.add(new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});
		}

		PriorityQueue<int[]> in = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);

		for (int i = 0; i < K; i++) {
			if (!q.isEmpty()) {
				int[] curr = q.poll();
				in.add(new int[]{curr[0], curr[1], i});
			}
		}

		PriorityQueue<int[]> out = new PriorityQueue<>((n1, n2) -> {
			if (n1[1] == n2[1]) return n2[2] - n1[2];
			return n1[1] - n2[1];
		});

		PriorityQueue<Integer> tmp = new PriorityQueue<>((n1, n2) -> (n1 - n2));
		while (!in.isEmpty()) {
			if (!in.isEmpty()) {
				// 계산 끝나고 나가기
				int[] curr = in.poll();
				out.add(curr);
				tmp.add(curr[2]);

				// 동일하게 끝나는 경우가 있는지 확인.
				while (!in.isEmpty() && in.peek()[1] == curr[1] && in.size() < K) {
					// 있다면 다음 사람 또 들어오기.
					int[] node = in.poll();
					out.add(node);
					tmp.add(node[2]);
				}

				while (!tmp.isEmpty() && !q.isEmpty()) {
					int[] next = q.poll();
					in.add(new int[]{next[0], next[1] + curr[1], tmp.poll()});
				}
			}
		}

		int idx = 1;
		long sum = 0;
		while (!out.isEmpty()) {
			sum += (out.poll()[0] * 1L * idx++);
		}
		System.out.println(sum);
	}
}
