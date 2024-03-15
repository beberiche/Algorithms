package Q22856_트리_순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 중위순회 -> end 노드 찾기
	// 유사중위순회 -> end 노드 도달 시 종료
	private int N, cnt;
	private boolean check;
	private Node a[], end;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(cnt);
	}

	private void solve() {
		inOrder(a[1]);
		similarInOrder(a[1]);
	}

	private void similarInOrder(Node node) {
		if (node.left != null) {
			cnt++;
			similarInOrder(node.left);
			if (check) return;
			cnt++;
		}


		if (node.right != null) {
			cnt++;
			similarInOrder(node.right);
			if (check) return;
			cnt++;
		}

		if (node == end) {
			check = true;
		}
	}

	private void inOrder(Node node) {
		if (node.left != null) inOrder(node.left);
		end = node;
		if (node.right != null) inOrder(node.right);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		a = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(stk.nextToken());
			int left = Integer.parseInt(stk.nextToken());
			int right = Integer.parseInt(stk.nextToken());
			if (a[node] == null) a[node] = new Node(node);
			if (left != -1) {
				if (a[left] == null) a[left] = new Node(left);
				a[node].left = a[left];
			}
			if (right != -1) {
				if (a[right] == null) a[right] = new Node(right);
				a[node].right = a[right];
			}
		}
	}

	private class Node {
		int val;
		Node left;
		Node right;


		Node(int val) {
			this.val = val;
		}
	}
}
