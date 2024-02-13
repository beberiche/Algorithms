package Q17696_블록_쌓기_게임;

class UserSolution {

	private int C, l, r, newVal, MOD = (int) 1e6;
	private long a[], tree_max[], tree_min[], tree_sum[], lazy[], total;

	void init(int C) {
		this.C = C;
		int H = (int) Math.ceil(Math.log(C) / Math.log(2));
		int size = 1 << (H + 1);
		a = new long[size];
		tree_max = new long[size];
		tree_min = new long[size];
//		tree_sum = new long[size];
		total = 0;
		lazy = new long[size];
	}

	Solution.Result dropBlocks(int mCol, int mHeight, int mLength) {
		Solution.Result ret = new Solution.Result();
		l = mCol;
		r = mCol + mLength - 1;
		newVal = mHeight;
		total += mHeight * mLength;
		segment_tree_update(1, 0, C - 1);
		ret.top = (int) (tree_max[1] - tree_min[1]);
		ret.count = (int) ((total - 1L * tree_min[1] * C) % MOD);
		return ret;
	}

	///////////////////////////////////////////
	///////////////////////////////////////////
	///////////////////////////////////////////
	///////////////////////////////////////////

	private void segment_tree_update(int nodeIdx, int st, int ed) {
//		segment_tree_lazy(nodeIdx, st, ed);
		if (r < st || l > ed) return;

		if (l <= st && ed <= r) {
			a[nodeIdx] += newVal;
			tree_max[nodeIdx] += newVal;
			tree_min[nodeIdx] += newVal;
//			tree_sum[nodeIdx] += (ed - st + 1) * newVal;
//			if (st != ed) {
//				lazy[nodeIdx * 2] += newVal;
//				lazy[nodeIdx * 2 + 1] += newVal;
//			}
			return;
		}


		int mid = (st + ed) / 2;
		segment_tree_update(nodeIdx * 2, st, mid);
		segment_tree_update(nodeIdx * 2 + 1, mid + 1, ed);
		tree_min[nodeIdx] = Math.min(tree_min[nodeIdx * 2], tree_min[nodeIdx * 2 + 1]) + a[nodeIdx];
		tree_max[nodeIdx] = Math.max(tree_max[nodeIdx * 2], tree_max[nodeIdx * 2 + 1]) + a[nodeIdx];
//		tree_sum[nodeIdx] = tree_sum[nodeIdx * 2] + tree_sum[nodeIdx * 2 + 1];
	}

	private void segment_tree_lazy(int nodeIdx, int st, int ed) {
		if (lazy[nodeIdx] != 0) {
			tree_sum[nodeIdx] += (ed - st + 1) * lazy[nodeIdx];
			if (st != ed) {
				lazy[nodeIdx * 2] += lazy[nodeIdx];
				lazy[nodeIdx * 2 + 1] += lazy[nodeIdx];
			}
			lazy[nodeIdx] = 0;
		}
	}

}