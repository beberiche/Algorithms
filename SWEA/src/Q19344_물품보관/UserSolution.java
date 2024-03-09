package Q19344_물품보관;

public class UserSolution {
	// min, max tree 생성.
	private int N, a[], min_tree[], max_tree[], maxIdx, ans, aa[];

	void init(int N) {
		this.N = N;
		a = new int[N + 1];
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = 1 << (h + 1);
		min_tree = new int[size];
		max_tree = new int[size];
		init(1, 0, N - 1);
	}


	int stock(int mLoc, int mBox) {
		update(1, 0, N - 1, mLoc - 1, mBox);
//		ans = go(0, N - 1);
		return ans;
	}


	int ship(int mLoc, int mBox) {
		update(1, 0, N - 1, mLoc - 1, -mBox);
//		ans = go(0, N - 1);
		return ans;
	}

	int getHeight(int mLoc) {
		return a[mLoc - 1];
	}


	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////

	private void init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			max_tree[nodeIdx] = st;
			return;
		}

		int mid = (st + ed) / 2;
		int lIdx = nodeIdx * 2;
		int rIdx = nodeIdx * 2 + 1;
		init(lIdx, st, mid);
		init(rIdx, mid + 1, ed);
		max_tree[nodeIdx] = a[max_tree[lIdx]] >= a[max_tree[rIdx]] ? max_tree[lIdx] : max_tree[rIdx];
	}

	private void update(int nodeIdx, int st, int ed, int idx, int newVal) {
		if (idx < st || ed < idx) return;

		if (st == ed) {
			a[idx] += newVal;
			return;
		}

		int mid = (st + ed) / 2;
		int lIdx = nodeIdx * 2;
		int rIdx = nodeIdx * 2 + 1;

		update(nodeIdx * 2, st, mid, idx, newVal);
		update(nodeIdx * 2 + 1, mid + 1, ed, idx, newVal);

		max_tree[nodeIdx] = a[max_tree[lIdx]] >= a[max_tree[rIdx]] ? max_tree[lIdx] : max_tree[rIdx];
	}

	private int query(int nodeIdx, int st, int ed, int l, int r) {
		if (r < st || ed < l) {
			return N;
		}

		if (l <= st && ed <= r) {
			return max_tree[nodeIdx];
		}

		int mid = (st + ed) / 2;
		int lIdx = nodeIdx * 2;
		int rIdx = nodeIdx * 2 + 1;

		int left = query(lIdx, st, mid, l, r);
		int right = query(rIdx, mid + 1, ed, l, r);
		return a[left] >= a[right] ? left : right;
	}


}
