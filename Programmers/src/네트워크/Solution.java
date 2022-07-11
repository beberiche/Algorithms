package 네트워크;

import java.util.*;

class Solution {
	static int[] p;

	public int solution(int n, int[][] computers) {
		p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = i;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (computers[i][j] == 0)
					continue;

				int p1 = find(i);
				int p2 = find(j);
				if (p1 != p2)
					p[p1] = p2;
			}
		}

		List<Integer> network = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int rep = find(i);
			if (!network.contains(rep))
				network.add(rep);
		}

		return network.size();
	}

	private static int find(int rep) {
		if (p[rep] == rep)
			return rep;
		return p[rep] = find(p[rep]);
	}
}