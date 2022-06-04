package Q1267_작업순서;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	static List<Integer> list[];
	static int[] arr;
	static boolean[] visited;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int t = 1; t <= T; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			list = new ArrayList[V + 1];
			arr = new int[V + 1];
			visited = new boolean[V + 1];

			for (int i = 1; i <= V; i++)
				list[i] = new ArrayList<>();

			// 진입차수 갯수 배열 맹글기
			for (int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list[from].add(to);
				arr[to] += 1;
			}

			stack = new Stack<>();

			// 우선 DFS
			for (int i = 1; i <= V; i++) {
				if (arr[i] == 0) {
					sort(i);
				}
			}

			System.out.print("#" + t + " ");
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
	}

	static void sort(int i) {
		visited[i] = true;
		for (int n : list[i]) {
			if (visited[n])
				continue;
			sort(n);
		}
		stack.push(i);
	}
}
