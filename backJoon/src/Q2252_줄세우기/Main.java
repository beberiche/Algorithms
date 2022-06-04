package Q2252_줄세우기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Integer> list[];
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		list = new ArrayList[V + 1];
		arr = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList();
		}

		// 진입차수
		for (int i = 0; i < E; i++) {
			int fr = sc.nextInt();
			int re = sc.nextInt();

			list[fr].add(re);
			arr[re]++;
		}

		// 큐 부르기
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= V; i++) {
			if (arr[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			for (int n : list[curr]) {
				arr[n]--;
				if (arr[n] == 0) {
					q.add(n);
				}
			}
		}
	}
}
