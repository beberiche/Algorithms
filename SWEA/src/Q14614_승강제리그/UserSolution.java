package Q14614_승강제리그;

import java.util.*;

class UserSolution {
	private int l_size;
	private TreeSet<int[]> t[][];
	private List<int[]> order;

	void init(int N, int L, int mAbility[]) {
		l_size = N / L;
		t = new TreeSet[L][2];

		for (int i = 0; i < N; i++) {
			if (i % l_size == 0) {
				t[i / l_size][0] = new TreeSet<>((n1, n2) -> compare(n1, n2));
				t[i / l_size][1] = new TreeSet<>((n1, n2) -> compare(n1, n2));
			}
			t[i / l_size][0].add(new int[]{i, mAbility[i]});
		}

		order = new ArrayList<>();
		int mid_size = l_size / 2;
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < mid_size; j++) {
				t[i][1].add(t[i][0].pollLast());
			}
			if (i > 0) order.add(new int[]{i - 1, i});
		}
	}


	int compare(int[] n1, int[] n2) {
		if (n1[1] == n2[1]) return n1[0] - n2[0];
		return n2[1] - n1[1];
	}

	int move() {
		Queue<int[]> left = new LinkedList<>();
		Queue<int[]> right = new LinkedList<>();
		int ret = 0;
		for (int i = 0; i < order.size(); i++) {
			int[] curr = order.get(i);
			int[] min = t[curr[0]][1].pollLast();
			int[] max = t[curr[1]][0].pollFirst();
			left.add(max);
			right.add(min);
			ret += (max[0] + min[0]);
		}

		for (int i = 0; i < order.size(); i++) {
			int[] curr = order.get(i);
			t[curr[0]][1].add(left.poll());
			t[curr[1]][0].add(right.poll());
		}

		for (int i = 0; i < t.length; i++) {
			check(i);
		}

		return ret;
	}

	private void check(int idx) {
		TreeSet<int[]> left = t[idx][0];
		TreeSet<int[]> right = t[idx][1];

		int[] leftLast = left.pollLast();
		int[] rightFirst = right.pollFirst();

		if (compare_b(leftLast, rightFirst)) {
			int[] l = left.pollLast();
			int[] r = right.pollFirst();
			left.add(r);
			right.add(l);
		}

	}

	boolean compare_b(int[] n1, int[] n2) {
		if (n1[1] == n2[1]) return n1[0] - n2[0] > 0;
		return n2[1] - n1[1] > 0;
	}


	int trade() {
		Queue<int[]> left = new LinkedList<>();
		Queue<int[]> right = new LinkedList<>();
		int ret = 0;
		for (int i = 0; i < order.size(); i++) {
			int[] curr = order.get(i);
			int[] mid = t[curr[0]][0].pollLast();
			int[] max = t[curr[1]][0].pollFirst();
			left.add(max);
			right.add(mid);
			ret += (max[0] + mid[0]);
		}

		for (int i = 0; i < order.size(); i++) {
			int[] curr = order.get(i);
			t[curr[0]][0].add(left.poll());
			t[curr[1]][0].add(right.poll());
		}

		for (int i = 0; i < t.length; i++) {
			check(i);
		}

		return ret;
	}


}