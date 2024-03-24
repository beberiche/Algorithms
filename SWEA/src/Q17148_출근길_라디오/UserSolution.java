package Q17148_출근길_라디오;

import java.util.*;

import static java.lang.Math.*;


class UserSolution {
	private Map<Integer, List<Integer>> map;
	private int N, mID, mNewTime, l, r;
	private int a[], tree[];

	void init(int N, int M, int mType[], int mTime[]) {
		this.N = N - 1;
		a = new int[N - 1];
		map = new HashMap<>();
		int H = (int) ceil(log(N - 1) / log(2));
		tree = new int[1 << (H + 1)];
		for (int i = 0; i < N - 1; i++) {
			a[i] = mTime[i];
			if (!map.containsKey(mType[i])) map.put(mType[i], new ArrayList<>());

			map.get(mType[i]).add(i);
		}
		tree_init(1, 0, N - 2);
	}

	void destroy() {

	}

	void update(int mID, int mNewTime) {
		this.mID = mID;
		this.mNewTime = mNewTime;

		tree_update(1, 0, N - 1);
	}

	int updateByType(int mTypeID, int mRatio256) {
		int sum = 0;
		for (int idx : map.getOrDefault(mTypeID, new ArrayList<>())) {
			mID = idx;
			mNewTime = (a[mID] * mRatio256) / 256;
			tree_update(1, 0, N - 1);
			sum += mNewTime;
		}


		return sum;
	}


	int calculate(int mA, int mB) {
		l = mA;
		r = mB;
		if (l > r) {
			int tmp = l;
			l = r;
			r = tmp;
		}

		r--;
		int ret = tree_query(1, 0, N - 1);
		return ret;
	}


	//////////////////////////////////////////////////////////////
	////// 아래 부터는 시험 참여자의 구현 함수들 입니다 //////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

	void tree_init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree[nodeIdx] = a[st];
			return;
		}

		int mid = (st + ed) / 2;
		tree_init(nodeIdx * 2, st, mid);
		tree_init(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}


	private void tree_update(int nodeIdx, int st, int ed) {
		if (mID < st || mID > ed) return;

		if (st == ed) {
			a[mID] = mNewTime;
			tree[nodeIdx] = mNewTime;
			return;
		}

		int mid = (st + ed) / 2;
		tree_update(nodeIdx * 2, st, mid);
		tree_update(nodeIdx * 2 + 1, mid + 1, ed);
		tree[nodeIdx] = tree[nodeIdx * 2] + tree[nodeIdx * 2 + 1];
	}

	private int tree_query(int nodeIdx, int st, int ed) {
		if (ed < l || st > r) return 0;

		if (l <= st && ed <= r) return tree[nodeIdx];

		int mid = (st + ed) / 2;
		return tree_query(nodeIdx * 2, st, mid) + tree_query(nodeIdx * 2 + 1, mid + 1, ed);
	}
}