package Q1267_작업순서;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static List<Integer> list[];
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int t = 1; t <= T; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			list = new ArrayList[V + 1];

			for (int i = 1; i <= V; i++)
				list[i] = new ArrayList<>();

			// 진입차수 갯수 배열 맹글기
			arr = new int[V + 1];
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list[from].add(to);
				arr[to] += 1;
			}

			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= V; i++) {
				if (arr[i] == 0)
					q.add(i);
			}

			System.out.print("#" + t + " ");
			while (!q.isEmpty()) {
				int curr = q.poll();
				System.out.print(curr + " ");
				for (int n : list[curr]) {
					arr[n] -= 1;
					if (arr[n] == 0) {
						q.add(n);
					}
				}
			}
			System.out.println();
		}

	}
}
