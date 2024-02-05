package Q14707_단어검색;

import java.util.HashMap;

class Node {
	Character ch;
	int cnt;
	HashMap<Character, Node> m;

	public Node(Character ch) {
		this.ch = ch;
		cnt = 0;
		m = new HashMap<>();
	}
}

class UserSolution {
	private Node root;
	private int ret;

	void init() {
		root = new Node(null);
	}

	int add(char str[]) {
		ret = 0;
		goAdd(str, 0, root);
		return ret;
	}

	int remove(char str[]) {
		return goRemove(str, 0, root);
	}


	int search(char str[]) {
		return goSearch(str, 0, root);
	}


	///////////////////////////////////
	///////////////////////////////////
	///////////////////////////////////

	private void goAdd(char[] str, int idx, Node curr) {
		if (str[idx] == '\0') {
			ret = ++curr.cnt;
			return;
		}
		if (!curr.m.containsKey(str[idx])) curr.m.put(str[idx], new Node(str[idx]));
		Node next = curr.m.get(str[idx]);
		goAdd(str, idx + 1, next);
		curr.cnt++;
	}

	private int goSearch(char[] str, int idx, Node curr) {
		if (str[idx] == '\0') {
			return curr.m.size() == 0 ? curr.cnt : 0;
		}

		int ret = 0;
		if (str[idx] == '?') {
			for (Character key : curr.m.keySet()) {
				ret += goSearch(str, idx + 1, curr.m.get(key));
			}
		} else {
			Node next = curr.m.getOrDefault(str[idx], null);
			if (next != null) ret += goSearch(str, idx + 1, next);
		}
		return ret;
	}

	private int goRemove(char[] str, int idx, Node curr) {
		if (str[idx] == '\0' && curr.m.size() == 0) {
			if (curr.m.size() == 0) {
				int tmp = curr.cnt;
				curr.cnt = 0;
				return tmp;
			} else {
				return 0;
			}
		}

		int ret = 0;
		if (str[idx] == '?') {
			for (Character key : curr.m.keySet()) {
				ret += goRemove(str, idx + 1, curr.m.get(key));
			}
		} else {
			Node next = curr.m.getOrDefault(str[idx], null);
			if (next != null) ret += goRemove(str, idx + 1, next);
		}
		curr.cnt -= ret;
		return ret;
	}
}