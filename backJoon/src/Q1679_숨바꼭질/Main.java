package Q1679_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int left, right; // 뒤로가기 앞으로 가기
	int warp;
	int cnt;

	Node(int idx) {
		this.left = idx - 1;
		this.right = idx + 1;
		this.warp = idx * 2;
		this.cnt = 0;
	}
}

public class Main {
	static Node[] map;
	static int ans;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		map = new Node[200001];
		for (int i = 0; i <= 200000; i++) {
			map[i] = new Node(i);
		}
		ans = 987654321;
		visited = new boolean[200001];
		BFS(N, K, 0);
		System.out.println(ans);
	}

	private static void BFS(int n, int k, int cnt) {
		Queue<Node> q = new LinkedList<>();
		visited[n] = true;
		q.add(map[n]);

		while (!q.isEmpty()) {
			Node curr = q.poll();

			int nLeft = curr.left;
			int nRight = curr.right;
			int nWarp = curr.warp;

			int idx = nLeft + 1;
			if (idx == k) {
				ans = map[idx].cnt;
				return;
			}

			if (nLeft >= 0 && !visited[nLeft]) {
				visited[nLeft] = true;
				q.add(map[nLeft]);
				map[nLeft].cnt = map[idx].cnt + 1;
			}

			if (nRight <= 200000 && !visited[nRight]) {
				visited[nRight] = true;
				q.add(map[nRight]);
				map[nRight].cnt = map[idx].cnt + 1;
			}

			if (nWarp <= 100000 && !visited[nWarp]) {
				visited[nWarp] = true;
				q.add(map[nWarp]);
				map[nWarp].cnt = map[idx].cnt + 1;
			}

		}
	}

}
