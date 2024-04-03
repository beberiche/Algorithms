package Q19457_신소재_케이블2;

import java.util.*;

class UserSolution {
	private class Edge {
		int node;
		int dist;

		Edge(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	private HashMap<Integer, List<Edge>> m;
	private Queue<int[]> q = new LinkedList<>();
	private HashSet<Integer> s = new HashSet<>();
	private int ret[] = new int[2];

	public void init(int mDevice) {
		m = new HashMap<>();
		m.put(mDevice, new ArrayList<>());
	}

	public void connect(int mOldDevice, int mNewDevice, int mLatency) {
		m.put(mNewDevice, new ArrayList<>());
		m.get(mOldDevice).add(new Edge(mNewDevice, mLatency));
		m.get(mNewDevice).add(new Edge(mOldDevice, mLatency));
	}

	public int measure(int mDevice1, int mDevice2) {
		q.add(new int[]{mDevice1, 0});
		s.add(mDevice1);
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0] == mDevice2) {
				q.clear();
				s.clear();
				return curr[1];
			}
			for (Edge e : m.get(curr[0])) {
				if (s.contains(e.node)) continue;
				s.add(e.node);
				q.add(new int[]{e.node, curr[1] + e.dist});
			}
		}

		return -1;
	}

	public int test(int mDevice) {
		Arrays.fill(ret, -1);
		dfs(mDevice, 0, mDevice);
		if (m.get(mDevice).size() > 1) {
			dfs(ret[0], 0, mDevice);
		}
		return ret[1];
	}


	private void dfs(int node, int dist, int visit) {
		s.add(node);

		if (s.contains(visit) && ret[1] < dist) {
			ret[0] = node;
			ret[1] = dist;
		}

		for (Edge e : m.get(node)) {
			if (s.contains(e.node)) continue;
			dfs(e.node, dist + e.dist, visit);
		}
		s.remove(node);
	}
}