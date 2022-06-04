package Q2930_힙;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(TC + " ");
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();
				if (n == 1) {
					pq.add(sc.nextInt());
					continue;
				}
				if (n == 2) {
					sb.append(pq.isEmpty() ? -1 : pq.poll()).append(" ");
				}
			}

			System.out.println(sb.toString());
		}
	}
}
