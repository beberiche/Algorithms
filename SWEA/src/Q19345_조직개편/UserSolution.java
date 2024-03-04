package Q19345_조직개편;

import java.util.HashMap;

class UserSolution {
	private Node root;
	private HashMap<Integer, Node> m;
	private int M, K, G;

	public void init(int mId, int mNum) {
		root = new Node(mId, mNum);
		m = new HashMap<>();
		m.put(mId, root);
		return;
	}

	public int add(int mId, int mNum, int mParent) {
		Node p = m.get(mParent);
		if (p.left != null && p.right != null) return -1;

		Node newNode = new Node(mId, mNum, p);
		if (p.left == null) {
			p.left = newNode;
		} else {
			p.right = newNode;
		}
		total_sum_parent(p, newNode.total);
		m.put(mId, newNode);
		return p.total;
	}

	private void total_sum_parent(Node Node, int sum) {
		Node.total += sum;
		if (Node.p == null) return;
		else total_sum_parent(Node.p, sum);
	}

	public int remove(int mId) {
		Node node = m.getOrDefault(mId, null);
		if (node == null) return -1;

		Node parent = node.p;

		if (parent.left != null && parent.left.equals(node)) {
			childRemove(parent.left);
			parent.left = null;
		} else if (parent.right != null && parent.right.equals(node)) {
			childRemove(parent.right);
			parent.right = null;
		}
		total_sum_parent(parent, -node.total);
		return node.total;
	}

	private void childRemove(Node node) {
		if (node.left != null) childRemove(node.left);
		if (node.right != null) childRemove(node.right);
		m.remove(node.id);
	}

	public int reorganize(int M, int K) {
		this.M = M;
		this.K = K;
		this.G = 1;
		go(root);
		if (G <= M) return 1;
		return 0;
	}

	private int go(Node node) {
		if (G > M || node.num > K) {
			G = M + 1;
			return 0;
		}

		Node left = node.left;
		Node right = node.right;

		int l_val = 0;
		int r_val = 0;
		if (left != null) l_val = go(left);
		if (right != null) r_val = go(right);

		if (l_val < r_val) {
			int tmp = r_val;
			r_val = l_val;
			l_val = tmp;
		}

		if (node.num + l_val > K) {
			G++;
			l_val = 0;
		}

		if (node.num + r_val > K) {
			G++;
			r_val = 0;
		}

		if (node.num + l_val + r_val > K) {
			G++;
			l_val = 0;
		}
		return l_val + node.num + r_val;
	}

	private class Node {
		int id, num, total;
		Node p;
		Node left;
		Node right;

		Node(int id, int num) {
			this.id = id;
			this.num = num;
			this.total = num;
		}

		// parent도 추가
		Node(int id, int num, Node p) {
			this.id = id;
			this.num = num;
			this.total = num;
			this.p = p;
		}
	}
}