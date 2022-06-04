package Q11000_강의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int st, ed;

	public Node(int st, int ed) {
		this.st = st;
		this.ed = ed;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		List<Node> list = new ArrayList<>();

		while (--N >= 0) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.st == o2.st) {
				return o1.ed - o2.ed;
			}
			return o1.st - o2.st;
		});

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.ed - o2.ed);

		for (Node curr : list) {
			if (!pq.isEmpty() && pq.peek().ed <= curr.st)
				pq.poll();
			pq.add(curr);
		}
		System.out.println(pq.size());
	}
}