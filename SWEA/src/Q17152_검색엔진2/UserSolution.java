package Q17152_검색엔진2;

import java.util.*;

class UserSolution {
	private Map<Integer, Set<Node>> r_map;
	private Node root;
	private int gId;
	private int rank;
	private PriorityQueue<Node> pq;

	void init() {
		r_map = new HashMap<>();
		root = new Node();
		gId = 1;
		pq = new PriorityQueue<>((n1, n2) -> {
			if (n1.count == n2.count) return n1.str.compareTo(n2.str);
			return n2.count - n1.count;
		});
	}

	void search(char mStr[], int mCount) {
		trie_add_count(mStr, root, 0, new StringBuilder(), mCount);
	}

	Solution.Result recommend(char mStr[]) {
		Solution.Result res = new Solution.Result();
		Node node = trie_search(mStr, root, 0);
		Node p = root;
		for (int i = 0; i <= 7; i++) {
			rank = 1;
			trie_search_greater_count(p, node.count, node.str);
			if (rank <= 5) {
				res.mOrder = i;
				res.mRank = rank;
				break;
			}
			p = p.m.get(mStr[i]);
		}
		trie_add_count(mStr, root, 0, new StringBuilder(), 1);
		return res;
	}


	int relate(char mStr1[], char mStr2[]) {
		Node node1 = trie_search(mStr1, root, 0);
		Node node2 = trie_search(mStr2, root, 0);

		int newCount = node1.count + node2.count;
		if (node1.rId == null && node2.rId == null) {
			r_map.put(gId, new HashSet<>());
			Set<Node> s = r_map.get(gId);
			node1.rId = gId;
			node2.rId = gId;
			s.add(node1);
			s.add(node2);
			for (Node n : s) {
				n.count = newCount;
			}
			gId++;
		} else if (node1.rId != null) {
			Set<Node> s = r_map.get(node1.rId);
			node2.rId = node1.rId;
			s.add(node2);
			for (Node n : s) {
				n.count = newCount;
			}
		} else if (node2.rId != null) {
			Set<Node> s = r_map.get(node2.rId);
			node1.rId = node2.rId;
			s.add(node1);
			for (Node n : s) {
				n.count = newCount;
			}
		} else {
			Set<Node> s1 = r_map.get(node1.rId);
			Set<Node> s2 = r_map.get(node2.rId);

			// s2 노드를 모두 s1으로 이양;
			for (Node n : s2) {
				n.rId = node1.rId;
				s1.add(n);
			}

			// 기존 s2 삭제.
			r_map.remove(node2.rId);

			for (Node n : s1) {
				n.count = newCount;
			}
		}

		return newCount;
	}

	void rank(char mPrefix[], int mRank, char mReturnStr[]) {
		Node node = trie_search(mPrefix, root, 0);
		trie_search_by_rank(node);
		Node rank_node = null;
		while (--mRank >= 0) {
			rank_node = pq.poll();
		}
		for (int i = 0; i < rank_node.str.length(); i++) {
			mReturnStr[i] = rank_node.str.charAt(i);
		}
		pq.clear();
	}


	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////

	private class Node {
		Integer rId; // relatedId;
		String str;
		boolean isEnd;
		int count;
		Map<Character, Node> m = new HashMap<>();
	}

	private String charArrToString(char[] ch_arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ch_arr.length; i++) {
			if (ch_arr[i] == '\0') break;
			sb.append(ch_arr[i]);
		}
		return sb.toString();
	}

	private void trie_add_count(char[] mStr, Node curr, int idx, StringBuilder sb, int count) {
		if (mStr[idx] == '\0') {
			curr.isEnd = true;
			if (curr.rId != null) {
				for (Node n : r_map.get(curr.rId)) n.count += count;
			} else {
				curr.count += count;
			}
			return;
		}

		if (!curr.m.containsKey(mStr[idx])) curr.m.put(mStr[idx], new Node());

		sb.append(mStr[idx]);

		Node next = curr.m.get(mStr[idx]);
		next.str = sb.toString();
		trie_add_count(mStr, next, idx + 1, sb, count);
	}

	private Node trie_search(char[] mStr, Node curr, int idx) {
		if (mStr[idx] == '\0') {
			return curr;
		}

		return trie_search(mStr, curr.m.get(mStr[idx]), idx + 1);
	}

	private void trie_search_greater_count(Node curr, int count, String str) {
		if (rank > 5) return;

		if (curr.isEnd) {
			if (curr.count > count || (curr.count == count && curr.str.compareTo(str) < 0)) {
				rank++;
			}
		}

		for (Node next : curr.m.values()) {
			trie_search_greater_count(next, count, str);
		}
	}

	private void trie_search_by_rank(Node curr) {
		for (Node next : curr.m.values()) {
			if (next.isEnd) pq.add(next);
			trie_search_by_rank(next);
		}
	}
}
