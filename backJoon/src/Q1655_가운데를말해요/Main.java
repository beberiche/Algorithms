package Q1655_가운데를말해요;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> L = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> R = new PriorityQueue<>((o1, o2) -> o1 - o2);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				L.add(n);
			} else {
				R.add(n);
			}
			if (!L.isEmpty() && !R.isEmpty()) {
				if (L.peek() > R.peek()) {
					int tmp = L.poll();
					L.add(R.poll());
					R.add(tmp);
				}
			}
			sb.append(L.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
