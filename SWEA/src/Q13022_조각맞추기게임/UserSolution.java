package Q13022_조각맞추기게임;

import java.util.*;

class UserSolution {

	HashMap<String, List<Integer>> m1;
	HashMap<Integer, String> m2;
	List<Integer> list;

	void init() {
		m1 = new HashMap<>();
		m2 = new HashMap<>();
		list = new ArrayList<>();
		list.add(0);
	}

	void makeWall(int mHeights[]) {
		for (int i = 0; i < 5; i++) {
			list.add(mHeights[i]);
		}
		if (list.size() <= 6) {
			int l = 1;
			int r = 5;
			add_hash_to_map(l, r);
		} else {
			int l = list.size() - 9;
			int r = l + 4;
			for (int i = 0; i < 5; i++) {
				add_hash_to_map(l, r);
				l++;
				r++;
			}
		}
	}

	int matchPiece(int mHeights[]) {
		String key = find_key_for_heights(mHeights);
		int ret = -1;
		if (m1.containsKey(key)) {
			Collections.sort(m1.get(key), Collections.reverseOrder());

			int idx = m1.get(key).get(0);
			list.subList(idx, idx + 5).clear();
			ret = idx;
			for (int i = idx; i < idx + 5; i++) {
				List<Integer> list = m1.get(m2.get(i));
				for (Integer n : list) {
					if (n == i) list.remove(n);
				}
				m2.remove(i);
			}
			for (int i = idx - 4 < 1 ? 1 : idx - 4; i < list.size() - 4; i++) {
				m1.remove(m2.get(i));
				m2.remove(i);
				add_hash_to_map(i, i + 4);
			}

		}
		return ret;
	}


	private void add_hash_to_map(int l, int r) {
		if (r >= list.size()) return;

		int num = list.get(l);
		StringBuilder sb = new StringBuilder();

		for (int i = l; i <= r; i++) {
			sb.append(list.get(i) - num);
		}
		String key = sb.toString();
		if (!m1.containsKey(key)) m1.put(key, new ArrayList<>());
		m1.get(key).add(l);
		m2.put(l, key);
	}

	private String find_key_for_heights(int mheights[]) {
		int num = mheights[4];
		int[] a = new int[5];

		StringBuilder sb = new StringBuilder();
		for (int i = 4, j = 0; i >= 0 && j < 5; i--, j++) {
			a[j] = mheights[i] - num;
			sb.append(a[j] * -1);
		}
		return sb.toString();
	}
}
