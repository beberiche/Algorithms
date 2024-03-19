package Q19432_국가행정;

import java.util.Arrays;
import java.util.PriorityQueue;

class UserSolution {
	private int population[], edge[], dists[], tree_sum[], idx, newVal, l, r;
	private PriorityQueue<int[]> pq;

	void init(int N, int mPopulation[]) {
		population = new int[N];
		pq = new PriorityQueue<>((n1, n2) -> {
			if (n1[2] == n2[2]) return n1[0] - n2[0];
			return n2[2] - n1[2];
		});
		dists = new int[N - 1];
		int H = (int) Math.ceil(Math.log(N - 1) / Math.log(2));
		tree_sum = new int[1 << (H + 1)];

		for (int i = 0; i < N; i++) {
			population[i] = mPopulation[i];
			if (i > 0) {
				int dist = population[i - 1] + population[i];
				dists[i - 1] = dist;
				pq.add(new int[]{i - 1, i, dist});
			}
		}

		segment_tree_init(1, 0, N - 2);
		edge = new int[N - 1];
		Arrays.fill(edge, 1);
	}


	int expand(int M) {
		int ret = 0;
		for (int i = 0; i < M; i++) {
			int[] curr = pq.poll();
			ret = (population[curr[0]] + population[curr[1]]) / ++edge[curr[0]];
			idx = curr[0];
			newVal = ret;
			segment_tree_update(1, 0, population.length - 2);
			pq.add(new int[]{curr[0], curr[1], ret});
		}
		return ret;
	}


	int calculate(int mFrom, int mTo) {
		int st = mFrom;
		int ed = mTo;

		if (st > ed) {
			int tmp = st;
			st = ed;
			ed = tmp;
		}
		l = st;
		r = ed-1;

		int ans = segment_tree_query(1, 0, population.length - 2);
		return ans;
	}

	int divide(int mFrom, int mTo, int K) {
		int st = mFrom;
		int ed = mTo;

		if (st > ed) {
			int tmp = st;
			st = ed;
			ed = tmp;
		}


		int l = Integer.MAX_VALUE; // 마을 중 가장 인구가 적은 마을
		int r = 0; // 범위 내 총 인구 수
		for (int i = st; i < ed; i++) {
			l = Math.min(l, population[i]);
			r += population[i];
		}


		int ret = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			int cnt = 1;
			int sum = population[st];
			for (int i = st + 1; i <= ed; i++) {
				sum += population[i];
				if (sum > mid) {
					cnt++;
					if (cnt > K) break;
					sum = population[i];
				}
			}

			if (cnt <= K) {
				ret = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}


		return ret;
	}

	//////////////////////////////
	//////////////////////////////


	private void segment_tree_init(int nodeIdx, int st, int ed) {
		if (st == ed) {
			tree_sum[nodeIdx] = dists[st];
			return;
		}

		int mid = (st + ed) / 2;
		segment_tree_init(nodeIdx * 2, st, mid);
		segment_tree_init(nodeIdx * 2 + 1, mid + 1, ed);
		tree_sum[nodeIdx] = tree_sum[nodeIdx * 2] + tree_sum[nodeIdx * 2 + 1];
	}

	private void segment_tree_update(int nodeIdx, int st, int ed) {
		if (idx < st || ed < idx) {
			return;
		}

		if (st == ed) {
			dists[idx] = newVal;
			tree_sum[nodeIdx] = newVal;
			return;
		}

		int mid = (st + ed) / 2;
		segment_tree_update(nodeIdx * 2, st, mid);
		segment_tree_update(nodeIdx * 2 + 1, mid + 1, ed);
		tree_sum[nodeIdx] = tree_sum[nodeIdx * 2] + tree_sum[nodeIdx * 2 + 1];
	}

	private int segment_tree_query(int nodeIdx, int st, int ed) {
		if (r < st || ed < l) {
			return 0;
		}

		if (l <= st && ed <= r) {
			return tree_sum[nodeIdx];
		}


		int mid = (st + ed) / 2;
		return segment_tree_query(nodeIdx * 2, st, mid) + segment_tree_query(nodeIdx * 2 + 1, mid + 1, ed);
	}
}