package Q1238_Contact;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[] visited;
	static ArrayList<Integer>[] list;
	static Queue<Integer> q;
	static int maxDepth;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int V = sc.nextInt(); // 데이터의 수
			int st = sc.nextInt(); // 시작 수

			visited = new int[101];
			list = new ArrayList[101];
			ans = 0;
			maxDepth = 0;

			// 리스트 초기화.
			for (int i = 1; i < 101; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 1; i <= V / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list[from].add(to);
			}

			BFS(st);
			System.out.println("#" + t + " " + ans);
		}
	}

	static void BFS(int st) {
		q = new LinkedList<>();

		q.addAll(list[st]);
		visited[st] = 1;
		maxDepth = Math.max(maxDepth, visited[st]);

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int n : list[curr]) {
				if (visited[n] != 0)
					continue;
				visited[n] = visited[curr] + 1;
				q.add(n);
				maxDepth = Math.max(maxDepth, visited[n]);
			}

		}

		// 들어갔다가 바로 끝난 경우
		if (maxDepth == 1) {
			ans = list[st].get(0);
			return;
		}

		for (int i = 1; i <= 100; i++) {
			if (visited[i] == maxDepth) {
				ans = i;
			}
		}

		if (ans == 0)
			ans = -1;

	}
}
