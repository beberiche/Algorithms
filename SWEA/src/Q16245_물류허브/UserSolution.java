package Q16245_물류허브;

import java.util.*;

class UserSolution {
	private int len;
	private final int INF = (int) 1e9;
	private List<int[]> list[], list_rev[];
	private HashMap<Integer, Integer> mIdx;

	public int init(int N, int sCity[], int eCity[], int mCost[]) {
		list = new ArrayList[604];
		list_rev = new ArrayList[604];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			list_rev[i] = new ArrayList<>();
		}

		mIdx = new HashMap<>();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			int st = sCity[i];
			int ed = eCity[i];
			int dist = mCost[i];

			if (!mIdx.containsKey(st)) mIdx.put(st, ++idx);
			if (!mIdx.containsKey(ed)) mIdx.put(ed, ++idx);

			list[mIdx.get(st)].add(new int[]{mIdx.get(ed), dist});
			list_rev[mIdx.get(ed)].add(new int[]{mIdx.get(st), dist});
		}
		len = idx;
		return idx;
	}

	public void add(int sCity, int eCity, int mCost) {
		list[mIdx.get(sCity)].add(new int[]{mIdx.get(eCity), mCost});
		list_rev[mIdx.get(eCity)].add(new int[]{mIdx.get(sCity), mCost});
	}

	public int cost(int mHub) {

		return dijkstra(mIdx.get(mHub), list) + dijkstra(mIdx.get(mHub), list_rev);
	}

	private int dijkstra(int start, List<int[]> list[]) {
		int[] dist = new int[len + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);

		pq.add(new int[]{start, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (int[] next : list[curr[0]]) {
				if (dist[next[0]] > curr[1] + next[1]) {
					dist[next[0]] = curr[1] + next[1];
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}

		int ans = 0;
		for (int i = 1; i < dist.length; i++) {
			ans += dist[i];
		}

		return ans;
	}
}