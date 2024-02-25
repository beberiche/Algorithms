package Q19343_전기차대여소;

import java.util.*;

class UserSolution {
	private int map[][], INF = (int) 1e6, range, dr[] = {-1, 0, 1, 0}, dc[] = {0, -1, 0, 1}, charges, dist[][];
	//	private Map<Integer, List<int[]>> m;
	private List<int[]> m[];
	private Queue<int[]> q = new LinkedList<>();
	private PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);

	void init(int N, int mRange, int mMap[][]) {
		map = new int[N][N];
		range = mRange;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = mMap[i][j];
			}
		}
		m = new ArrayList[200];
//		m = new HashMap<>();
		charges = 0;
	}

	void add(int mID, int mRow, int mCol) {
//		m.put(mID, new ArrayList<>());
		m[mID]= new ArrayList<>();
		if (mID > 0) bfs(mID, mRow, mCol);
		map[mRow][mCol] = INF + mID;
		charges++;
	}

	int distance(int mFrom, int mTo) {
		return dijkstra(mFrom, mTo);
	}


	private void bfs(int mID, int mRow, int mCol) {
		q.add(new int[]{mRow, mCol, 0});
		boolean visited[][] = new boolean[map.length][map.length];
		visited[mRow][mCol] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (map[curr[0]][curr[1]] >= INF) {
				int id = map[curr[0]][curr[1]] - INF;
				m[id].add(new int[]{mID, curr[2]});
				m[mID].add(new int[]{id, curr[2]});
			}

			if (curr[2] >= range) continue;

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length || visited[nr][nc] || map[nr][nc] == 1)
					continue;

				visited[nr][nc] = true;
				q.add(new int[]{nr, nc, curr[2] + 1});
			}
		}
	}

	private int dijkstra(int mFrom, int mTo) {
		pq.add(new int[]{mFrom, 0});
		int dist[] = new int[charges];
		Arrays.fill(dist, INF);
		dist[mFrom] = 0;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			if (curr[0] == mTo) continue;

			for (int[] next : m[curr[0]]) {
				if (dist[next[0]] > next[1] + curr[1]) {
					dist[next[0]] = next[1] + curr[1];
					pq.add(new int[]{next[0], dist[next[0]]});
				}
			}
		}

		return dist[mTo] == INF ? -1 : dist[mTo];
	}
}