package Q5639_이진검색트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
	int num;
	Node left;
	Node right;

	Node(int num) {
		this.num = num;
	}

	Node(int num, Node left, Node right) {
		this.num = num;
		this.left = left;
		this.right = right;
	}

	void preOrder(int curr) {
		if (curr < this.num) {
			if (this.left != null)
				this.left.preOrder(curr);
			else
				this.left = new Node(curr);
		} else {
			if (this.right != null)
				this.right.preOrder(curr);
			else
				this.right = new Node(curr);
		}
	}

}

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node(Integer.parseInt(br.readLine()));
		while (true) {
			String temp = br.readLine();
			if (temp != null)
				node.preOrder(Integer.parseInt(temp));
			else
				break;
		}

		postOrder(node);
		System.out.print(sb);
	}

	private static void postOrder(Node node) {
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null)
			postOrder(node.right);
		sb.append(node.num).append("\n");
	}
}
