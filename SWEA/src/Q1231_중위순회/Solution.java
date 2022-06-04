package Q1231_중위순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
	String data;
	Node left;
	Node right;
}

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(br.readLine());

			String[][] arr = new String[N + 1][];
			Node[] nodeArr = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				arr[i] = br.readLine().split(" ");
				nodeArr[i] = new Node();
				nodeArr[i].data = arr[i][1];
				nodeArr[i].left = null;
				nodeArr[i].right = null;
			}

			for (int i = 1; i <= N; i++) {
				if (arr[i].length == 4) {
					nodeArr[i].left = nodeArr[Integer.parseInt(arr[i][2])];
					nodeArr[i].right = nodeArr[Integer.parseInt(arr[i][3])];
				} else if (arr[i].length == 3) {
					nodeArr[i].left = nodeArr[Integer.parseInt(arr[i][2])];
				} else {
					break;
				}
			}
			System.out.print("#" + T + " ");
			inorder(nodeArr[1]);
			System.out.println();
		}
	}

	public static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data);
			inorder(node.right);
		}
	}
}
