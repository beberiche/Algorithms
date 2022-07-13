package Q1996_숫자고르기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> list;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		list = new ArrayList<>();
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			DFS(i, i);
			visited[i] = false;
		}

		Collections.sort(list);
		System.out.println(list.size());
		
		for (int n : list) {
			System.out.println(n);
		}

	}

	private static void DFS(int i, int goal) {
		// TODO Auto-generated method stub
		if (arr[i] == goal) {
			list.add(goal);
			return;
		}

		if (visited[arr[i]])
			return;

		visited[arr[i]] = true;
		DFS(arr[i], goal);
		visited[arr[i]] = false;

	}
}
