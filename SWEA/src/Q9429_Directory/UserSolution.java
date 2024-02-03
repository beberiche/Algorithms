package Q9429_Directory;

import java.util.ArrayList;
import java.util.List;

class Node {
	String name;
	Node parent;
	List<Node> child;
	int childCnt;


	Node(String name) {
		this.name = name;
		child = new ArrayList<>();
		this.childCnt = 0;
	}

}

class UserSolution {

	private final static int NAME_MAXLEN = 6;
	private final static int PATH_MAXLEN = 1999;
	private Node pool[];
	private Node root;
	private int idx;

	String changeToStr(char[] path) {
		return String.valueOf(path).substring(0, path.length - 1);
	}

	String[] changeToStrArr(char[] path) {
		return String.valueOf(path).substring(0, path.length - 1).split("/");
	}

	Node createNode(String name) {
		Node node = new Node(name);
		return pool[idx++] = node;
	}

	private void connectNode(Node parent, Node child) {
		child.parent = parent;
		parent.child.add(child);
	}

	private void disConnectNode(Node parent, Node child) {
		child.parent = null;
		parent.child.remove(child);
	}

	Node findNode(String[] path) {
		Node parent = root;
		for (int i = 1; i < path.length; i++) {
			for (Node c : parent.child) {
				if (c.name.equals(path[i])) {
					parent = c;
					break;
				}
			}
		}
		return parent;
	}

	void calChildCnt(Node startNode, int cnt) {
		Node curr = startNode.parent;
		while (curr != null) {
			curr.childCnt += cnt;
			curr = curr.parent;
		}
	}

	Node copy(Node node) {
		Node newNode = createNode(node.name);
		newNode.childCnt = node.childCnt;
		for (Node c : node.child) {
			Node newChild = copy(c);
			newChild.parent = newNode;
			newNode.child.add(newChild);
		}
		return newNode;
	}

	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////

	void init(int n) {
		pool = new Node[50050];
		idx = 0;
		root = createNode("/");
	}

	void cmd_mkdir(char[] path, char[] name) {
		// 새로운 노드 생성
		Node newChild = createNode(changeToStr(name));
		// char -> string
		String p[] = changeToStrArr(path);
		// 노드 찾기
		Node parent = findNode(p);
		// 부모, 자식 연결
		connectNode(parent, newChild);
		// child 갯수 추가
		calChildCnt(newChild, 1);
	}


	void cmd_rm(char[] path) {
		String p[] = changeToStrArr(path);
		Node node = findNode(p);

		// child 갯수 줄이기
		int childCnt = node.childCnt + 1;
		calChildCnt(node, -childCnt);

		// 연결 제거
		disConnectNode(node.parent, node);
	}

	void cmd_cp(char[] srcPath, char[] dstPath) {
		String sp[] = changeToStrArr(srcPath);
		String dp[] = changeToStrArr(dstPath);

		// 노드 찾기
		Node srcNode = findNode(sp);
		Node dstNode = findNode(dp);

		// 노드 복사
		Node copyNode = copy(srcNode);
		copyNode.parent = srcNode.parent;

		// 카피한 노드 연결
		connectNode(dstNode, copyNode);

		// 노드 자식 수 증가
		calChildCnt(copyNode, copyNode.childCnt + 1);
	}

	void cmd_mv(char[] srcPath, char[] dstPath) {
		String sp[] = changeToStrArr(srcPath);
		String dp[] = changeToStrArr(dstPath);

		// 노드 찾기
		Node srcNode = findNode(sp);
		Node dstNode = findNode(dp);

		// 기존 노드 수 제거
		int childCnt = srcNode.childCnt + 1;
		calChildCnt(srcNode, -childCnt);

		// 기존 노드의 연결 삭제
		disConnectNode(srcNode.parent, srcNode);

		// 새로운 노드에 추가
		connectNode(dstNode, srcNode);

		// 새로운 노드 자식 수 증가
		calChildCnt(srcNode, childCnt);
	}

	int cmd_find(char[] path) {
		String p[] = changeToStrArr(path);
		Node node = findNode(p);
		return node.childCnt;
	}
}
