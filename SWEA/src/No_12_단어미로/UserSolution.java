package No_12_단어미로;

import java.util.HashMap;
import java.util.TreeSet;

class UserSolution {
	private class Node implements Comparable<Node> {
		int id;
		String val;
		String st;
		String mid;
		String ed;
		String sub_st;
		String sub_ed;

		Node(int id, String val, String st, String mid, String ed, String sub_st, String sub_ed) {
			this.id = id;
			this.val = val;
			this.st = st;
			this.mid = mid;
			this.ed = ed;
			this.sub_st = sub_st;
			this.sub_ed = sub_ed;
		}

		@Override
		public int compareTo(Node o) {
			return this.val.compareTo(o.val);
		}
	}

	private HashMap<String, Integer> val_id;
	private HashMap<Integer, Node> id_node;

	private HashMap<String, TreeSet<Node>> st_node;
	private HashMap<String, TreeSet<Node>> mid_node;
	private HashMap<String, TreeSet<Node>> ed_node;

//	private HashMap<Integer, List<String>> id_st;
	//	private HashMap<Integer, String> id_mid;
//	private HashMap<Integer, List<String>> id_ed;

	private int curr;

	void init() {
		val_id = new HashMap<>();
		id_node = new HashMap<>();

		st_node = new HashMap<>();
		mid_node = new HashMap<>();
		ed_node = new HashMap<>();

//		id_st = new HashMap<>();
//		id_mid = new HashMap<>();
//		id_ed = new HashMap<>();
		curr = 0;
	}

	void addRoom(int mID, char mWord[], int mDirLen[]) {
		String val = charToString(mWord);

		String[] st_arr = findSt(val);
		String[] ed_arr = findEd(val);
		String mid = val.substring(4, 7);
		String st = mDirLen[0] == 2 ? st_arr[0] : st_arr[1];
		String ed = mDirLen[2] == 2 ? ed_arr[0] : ed_arr[1];
		String sub_st = mDirLen[0] == 2 ? st_arr[1] : st_arr[0];
		String sub_ed = mDirLen[2] == 2 ? ed_arr[1] : ed_arr[0];

		Node node = new Node(mID, val, st, mid, ed, sub_st, sub_ed);

		st_mapping(node, st_arr);
		mid_mapping(node, mid);
		ed_mapping(node, ed_arr);

		id_node.put(mID, node);
		val_id.put(node.val, mID);
	}


	void setCurrent(char mWord[]) {
		String val = charToString(mWord);
		curr = val_id.get(val);
	}

	int moveDir(int mDir) {
		// 현재 노드
		Node node = id_node.get(curr);

		int ret = 0;
		TreeSet<Node> t;

		if (mDir == 0) {
			// st로 이동하는 경우 st -> ed_node
			String st = node.st;
			t = ed_node.getOrDefault(st, null);
		} else if (mDir == 1) {
			// mid로 이동하는 경우
			String mid = node.mid;
			t = mid_node.getOrDefault(mid, null);
		} else {
			// ed로 이동하는 경우, ed -> st_node
			String ed = node.ed;
			t = st_node.getOrDefault(ed, null);
		}

		Node next_node;
		if (t == null || (next_node = findFirst(t, node.id)) == null) return 0;

		ret = next_node.id;

		if (ret != 0) curr = ret;
		return ret;
	}


	void changeWord(char mWord[], char mChgWord[], int mChgLen[]) {
		String val = charToString(mWord);
		// node 찾기
		Node node = id_node.get(val_id.get(val));

		/////////////////////////////////////////
		/// 기존 노드 삭제과정 //////////////////////
		/////////////////////////////////////////


		// 현재 관여하고 있는 st에 대해 삭제
		String st = node.st;
		String sub_st = node.sub_st;

		st_node.get(st).remove(node);
		if (st_node.get(st).size() == 0) st_node.remove(st);
		st_node.get(sub_st).remove(node);
		if (st_node.get(sub_st).size() == 0) st_node.remove(sub_st);


		// 현재 관여하고 있는 mid에 대해 삭제
		String mid = node.mid;
		mid_node.get(mid).remove(node);
		if (mid_node.get(mid).size() == 0) mid_node.remove(mid);


		// 현재 관여하고 있는 ed에 대해 삭제
		String ed = node.ed;
		String sub_ed = node.sub_ed;

		ed_node.get(ed).remove(node);
		if (ed_node.get(ed).size() == 0) ed_node.remove(ed);
		ed_node.get(sub_ed).remove(node);
		if (ed_node.get(sub_ed).size() == 0) ed_node.remove(sub_ed);

		val_id.remove(node.val);

		/////////////////////////////////////////
		/// 새 노드 업데이트 과정 ////////////////////
		/////////////////////////////////////////

		String newVal = charToString(mChgWord);

		String[] st_arr = findSt(newVal);
		String[] ed_arr = findEd(newVal);
		mid = newVal.substring(4, 7);
		st = mChgLen[0] == 2 ? st_arr[0] : st_arr[1];
		ed = mChgLen[2] == 2 ? ed_arr[0] : ed_arr[1];
		sub_st = mChgLen[0] == 2 ? st_arr[1] : st_arr[0];
		sub_ed = mChgLen[2] == 2 ? ed_arr[1] : ed_arr[0];

		Node newNode = new Node(node.id, newVal, st, mid, ed, sub_st, sub_ed);

		st_mapping(newNode, st_arr);
		mid_mapping(newNode, mid);
		ed_mapping(newNode, ed_arr);

		id_node.put(node.id, newNode);
		val_id.put(newNode.val, node.id);
	}


	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////


	private String charToString(char mWord[]) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < mWord.length; i++) {
			char ch = mWord[i];
			if (ch == '\0') break;
			sb.append(ch);
		}

		return sb.toString();
	}

	private String[] findSt(String val) {
		return new String[]{val.substring(0, 2), val.substring(0, 4)};
	}


	private String[] findEd(String val) {
		StringBuilder sb = new StringBuilder();
		for (int i = val.length() - 4; i < val.length(); i++) {
			sb.append(val.charAt(i));
		}
		String ret = sb.toString();
		return new String[]{ret.substring(2, 4), ret};
	}


	private void st_mapping(Node node, String[] st_arr) {
		if (!st_node.containsKey(st_arr[0])) {
			st_node.put(st_arr[0], new TreeSet<>());
		}
		st_node.get(st_arr[0]).add(node);

		if (!st_node.containsKey(st_arr[1])) {
			st_node.put(st_arr[1], new TreeSet<>());
		}
		st_node.get(st_arr[1]).add(node);
	}


	private void ed_mapping(Node node, String[] ed_arr) {
		if (!ed_node.containsKey(ed_arr[0])) {
			ed_node.put(ed_arr[0], new TreeSet<>());
		}
		ed_node.get(ed_arr[0]).add(node);

		if (!ed_node.containsKey(ed_arr[1])) {
			ed_node.put(ed_arr[1], new TreeSet<>());
		}
		ed_node.get(ed_arr[1]).add(node);
	}

	private void mid_mapping(Node node, String mid) {
		if (!mid_node.containsKey(mid)) {
			mid_node.put(mid, new TreeSet<>());
		}
		mid_node.get(mid).add(node);
	}

	private Node findFirst(TreeSet<Node> t, int id) {
		for (Node n : t) {
			if (n.id == id) continue;
			return n;
		}
		return null;
	}
}
