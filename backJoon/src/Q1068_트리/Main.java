package Q1068_트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> map[];
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new ArrayList[N];

		for (int i = 0; i < N; i++)
			map[i] = new ArrayList<>();

		int root = 0;
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n == -1) {
				root = i;
				continue;
			}
			map[n].add(i);
		}

		int delNode = sc.nextInt();

		if (delNode == root) {
			System.out.println(0);
			return;
		}

		cnt = 0;
		for (int i = 0; i < N; i++) {
			if (map[i].isEmpty()) {
				cnt++;
			}
		}

		int tempP = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < map[i].size(); j++) {
				if (map[i].get(j) == delNode) {
					tempP = i;
					idx = j;
				}
			}
		}

		map[tempP].remove(idx);
		// 노드 제거하기
		DFS(delNode);

		if (map[tempP].isEmpty()) {
			cnt++;
		}

		System.out.println(cnt);

	}

	public static void DFS(int delNode) {
		if (map[delNode].isEmpty()) {
			cnt--;
			return;
		}

		for (int i = 0; i < map[delNode].size(); i++) {
			DFS(map[delNode].get(i));
		}

	}

}
