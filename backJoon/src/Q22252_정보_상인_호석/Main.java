package Q22252_정보_상인_호석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, PriorityQueue<Integer>> m = new HashMap<>();
		long ans = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			if (cmd == 1) getInfo(stk, m);
			else ans += buyInfo(stk, m);
		}
		System.out.println(ans);
	}

	private static long buyInfo(StringTokenizer stk, Map<String, PriorityQueue<Integer>> m) {
		String name = stk.nextToken();
		int b = Integer.parseInt(stk.nextToken());
		PriorityQueue<Integer> pq = m.getOrDefault(name, new PriorityQueue<>((n1, n2) -> n2 - n1));
		if (!m.containsKey(name)) m.put(name, pq);
		long ret = 0;
		while (--b >= 0 && !pq.isEmpty()) ret += pq.poll();
		return ret;
	}

	private static void getInfo(StringTokenizer stk, Map<String, PriorityQueue<Integer>> m) {
		String name = stk.nextToken();
		int k = Integer.parseInt(stk.nextToken());
		PriorityQueue<Integer> pq = m.getOrDefault(name, new PriorityQueue<>((n1, n2) -> n2 - n1));
		if (!m.containsKey(name)) m.put(name, pq);
		while (--k >= 0) pq.add(Integer.parseInt(stk.nextToken()));
	}
}
