package Q27313_효율적인_애니메이션_감상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		List<Integer> list = new ArrayList<>();
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(stk.nextToken());
			if (num > M) continue;
			list.add(num);
		}

		Collections.sort(list);

		if (list.size() == 0) {
			System.out.println(0);
			return;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(list.get(0));
		int ans = 1;
		for (int i = 1; i < list.size(); i++) {
			if (pq.size() >= K) {
				if (pq.peek() + list.get(i) > M) break;
				else pq.add(pq.poll() + list.get(i));
			} else {
				pq.add(list.get(i));
			}
			ans++;
		}
		System.out.println(ans);
	}
}

