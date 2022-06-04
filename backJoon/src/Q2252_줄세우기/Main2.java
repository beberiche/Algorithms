package Q2252_줄세우기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	static List<Integer> list[];
	static int[] arr;
	static boolean[] visited;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		list = new ArrayList[V + 1];
		arr = new int[V + 1];
		visited = new boolean[V + 1];
		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList();

		// 진입차수
		for (int i = 0; i < E; i++) {
			int fr = sc.nextInt();
			int re = sc.nextInt();

			list[fr].add(re);
			arr[re]++;
		}

		stack = new Stack<>();

		for (int i = 1; i <= V; i++) {
			if (arr[i] == 0) {
				sort(i);
			}
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");

	}

	static void sort(int i) {
		visited[i] = true;
		for (int n : list[i]) {
			if (visited[n])
				continue;
			visited[n] = true;
			sort(n);
		}
		stack.push(i);
	}
}
