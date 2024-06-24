package Q17394_핑거_스냅;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int MAX = (int) 1e6 + 1;
		boolean[] noPrime = new boolean[MAX];
		noPrime[0] = true;
		noPrime[1] = true;
		for (int i = 2; i < MAX; i++) {
			if (!noPrime[i]) {
				for (int j = i + i; j < MAX; j += i) {
					noPrime[j] = true;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (--T >= 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int A = Integer.parseInt(stk.nextToken());
			int B = Integer.parseInt(stk.nextToken());

			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{N, 0});

			boolean visited[] = new boolean[MAX];
			visited[N] = true;
			int ret = -1;
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				if (curr[0] >= A && curr[0] <= B && !noPrime[curr[0]]) {
					ret = curr[1];
					break;
				}

				// 줄인다.
				int next1 = curr[0] / 2;
				if (!visited[next1]) {
					visited[next1] = true;
					q.add(new int[]{next1, curr[1] + 1});
				}

				int next2 = curr[0] / 3;
				if (!visited[next2]) {
					visited[next2] = true;
					q.add(new int[]{next2, curr[1] + 1});
				}

				int next3 = curr[0] - 1;
				if (0 <= next3 && !visited[next3]) {
					visited[next3] = true;
					q.add(new int[]{next3, curr[1] + 1});
				}


				// 늘린다.
				int next4 = curr[0] + 1;
				if (next4 < MAX && !visited[next4]) {
					visited[next4] = true;
					q.add(new int[]{next4, curr[1] + 1});
				}
			}
			sb.append(ret).append("\n");
		}
		System.out.print(sb.toString());
	}
}