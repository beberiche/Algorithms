package Q10472_십자뒤집기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (--T >= 0) {
			int num = 0;
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				String str = br.readLine();
				for (int j = 0; j < 3; j++) {
					char ch = str.charAt(j);
					if (ch == '*') num |= (1 << idx);
					idx++;
				}
			}

			Queue<int[]> q = new LinkedList<>();

			boolean[] visited = new boolean[(1 << 9)];
			visited[0] = true;
			q.add(new int[]{0, 0});

			int ans = 0;
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				if (curr[0] == num) {
					ans = curr[1];
					break;
				}

				for (int i = 0; i < 9; i++) {
					int copy = curr[0];

					int up = i - 3;
					int down = i + 3;
					int left = i / 3 == (i - 1) / 3 ? i - 1 : -1;
					int right = i / 3 == (i + 1) / 3 ? i + 1 : -1;

					copy ^= (1 << i);
					if (up >= 0) {
						copy ^= (1 << up);
					}
					if (down < 9) {
						copy ^= (1 << down);
					}
					if (left != -1) {
						copy ^= (1 << left);
					}
					if (right != -1) {
						copy ^= (1 << right);
					}

					if (visited[copy]) continue;
					visited[copy] = true;
					q.add(new int[]{copy, curr[1] + 1});
				}
			}
			System.out.println(ans);
		}
	}
}
