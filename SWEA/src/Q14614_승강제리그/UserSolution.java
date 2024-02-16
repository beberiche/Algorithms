package Q14614_승강제리그;

import java.util.*;

class UserSolution {
	private int g;
	private TreeSet<int[]> t[];
	private int sd[][][];

	void init(int N, int L, int mAbility[]) {
		g = N / L;
		t = new TreeSet[L];
		sd = new int[L][g][2];
		for (int i = 0; i < L; i++) {
			t[i] = new TreeSet<>((n1, n2) -> {
				if (n1[1] == n2[1]) return n1[0] - n2[0];
				return n2[1] - n1[1];
			});
		}
		for (int i = 0; i < N; i++) {
			t[i / g].add(new int[]{i, mAbility[i]});
			sd[i / g][i % g][0] = i;
			sd[i / g][i % g][1] = mAbility[i];
		}
	}

	int move() {
		int ret = 0;
		Queue<int[]> last = new LinkedList<>();
		Queue<int[]> first = new LinkedList<>();
		for (int i = 1; i < t.length; i++) {
			int[] n1 = t[i - 1].pollLast();
			int[] n2 = t[i].pollFirst();
			last.add(n1);
			first.add(n2);
		}

		int idx = 1;
		while (!last.isEmpty()) {
			int[] n1 = last.poll();
			int[] n2 = first.poll();

			t[idx].add(n1);
			t[idx - 1].add(n2);
			ret += n1[0] + n2[0];
			idx++;
		}
		return ret;
	}


	int trade() {
		int ret = 0;
		Queue<int[]> mid = new Li