package Q12886_돌그룹;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int stone1 = sc.nextInt();
		int stone2 = sc.nextInt();
		int stone3 = sc.nextInt();

		if ((stone1 + stone2 + stone3) % 3 != 0) {
			System.out.println(0);
		} else {
			boolean[][] visited = new boolean[1501][1501];
			Queue<int[]> q = new LinkedList<>();

			q.add(new int[] { stone1, stone2, stone3 });
			while (!q.isEmpty()) {
				int[] curr = q.poll();

				if (curr[0] == curr[1] && curr[1] == curr[2]) {
					System.out.println(1);
					return;
				}
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (i != j) {
							if (curr[i] < curr[j]) {
								if (visited[curr[i] + curr[i]][curr[j] - curr[i]])
									continue;

								visited[curr[i] + curr[i]][curr[j] - curr[i]] = true;
								q.add(new int[] { curr[i] + curr[i], curr[j] - curr[i],
										stone1 + stone2 + stone3 - curr[i] - curr[j] });
							} else if (curr[i] > curr[j]) {
								if (visited[curr[j] + curr[j]][curr[i] - curr[j]])
									continue;

								visited[curr[j] + curr[j]][curr[i] - curr[j]] = true;
								q.add(new int[] { curr[j] + curr[j], curr[i] - curr[j],
										stone1 + stone2 + stone3 - curr[i] - curr[j] });
							}
						}
					}
				}
			}
			System.out.println(0);
		}
	}
}
