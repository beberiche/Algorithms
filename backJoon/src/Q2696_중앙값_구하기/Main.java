package Q2696_중앙값_구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (--T >= 0) {
			int N = Integer.parseInt(br.readLine());

			int mid = N / 2 + 1;

			sb.append(mid).append("\n");

			PriorityQueue<Integer> min_pq = new PriorityQueue<>();
			PriorityQueue<Integer> max_pq = new PriorityQueue<>((n1, n2) -> n2 - n1);

			int cnt = N / 10 + 1;
			for (int c = 1; c <= cnt; c++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				int idx = 1;
				while (stk.hasMoreTokens()) {
					int num = Integer.parseInt(stk.nextToken());

					if (max_pq.size() == min_pq.size()) {
						max_pq.add(num);

						if (!min_pq.isEmpty() && max_pq.peek() > min_pq.peek()) {
							int max_n = max_pq.poll();
							int min_n = min_pq.poll();
							min_pq.add(max_n);
							max_pq.add(min_n);
						}
					} else {
						min_pq.add(num);
					}

					if (idx++ % 2 == 1) {
						sb.append(max_pq.peek()).append(" ");
					}
				}
				if (c % 2 == 0) sb.deleteCharAt(sb.length() - 1).append("\n");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.print(sb.toString());
	}
}
