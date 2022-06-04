package Q1991_트리순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
	char mid;
	Node left;
	Node right;
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Node[] arr = new Node[N];

		char a = 'A';
		for (int i = 0; i < N; i++) {
			Node node = new Node();
			node.mid = a++;
			arr[i] = node;
		}

		for (int i = 0; i < N - 1; i++) {
			char[] chArr = br.readLine().replace(" ", "").toCharArray();
			arr[chArr[0] - 65].left = chArr[1] == '.' ? null : arr[chArr[1] - 65];
			arr[chArr[0] - 65].right = chArr[2] == '.' ? null : arr[chArr[2] - 65];
		}
		preorder(arr[0]);
		System.out.println();
		inorder(arr[0]);
		System.out.println();
		postorder(arr[0]);

	}

	public static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.mid);
			inorder(node.right);
		}
	}

	public static void preorder(Node node) {
		if (node != null) {
			System.out.print(node.mid);
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.mid);
		}
	}
}
