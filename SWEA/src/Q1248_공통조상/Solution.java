package Q1248_공통조상;

import java.util.Scanner;

class Node {
	int head;
	int parent;
	int left = -1;
	int right = -1;
}

public class Solution {
	static Node[] nodeArr;
	static boolean visited[];
	static int root;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int T = 1; T <= N; T++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			nodeArr = new Node[V + 1];
			visited = new boolean[V + 1];

			for (int i = 1; i <= V; i++) {
				nodeArr[i] = new Node();
				nodeArr[i].head = i;
			}

			for (int i = 0; i < E; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();

				if (nodeArr[p].left == -1) {
					nodeArr[p].left = c;
				} else {
					nodeArr[p].right = c;
				}
				nodeArr[c].parent = p;
			}

			root = 1;

			while (true) {
				if (n1 != 1) {
					int p = nodeArr[n1].parent;
					if (visited[p]) {
						root = p;
						break;
					}
					visited[p] = true;
					n1 = p;
				}
				if (n2 != 1) {
					int p = nodeArr[n2].parent;
					if (visited[p]) {
						root = p;
						break;
					}
					visited[p] = true;
					n2 = p;
				}
			}
			cnt = 0;
			preorder(nodeArr[root]);
			System.out.println("#" + T + " " + root + " " + cnt);
		}

	}

	static void preorder(Node n) {
		cnt++;
		if (n.left != -1)
			preorder(nodeArr[n.left]);
		if (n.right != -1)
			preorder(nodeArr[n.right]);
	}
}
