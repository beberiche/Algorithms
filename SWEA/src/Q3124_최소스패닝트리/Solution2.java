package Q3124_최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2 {
	static int[] path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 간선행렬
			int[][] map = new int[E][3];
			path = new int[V + 1];

			for (int i = 1; i <= V; i++) {
				path[i] = i;
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
				map[i][2] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(map, (o1, o2) -> o1[2] - o2[2]);

			long ans = 0;

			for (int i = 0; i < E; i++) {
				int px = findSet(map[i][0]);
				int py = findSet(map[i][1]);

				if (px != py) {
					path[py] = px;
					ans += map[i][2];
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static int findSet(int i) {
		if (i == path[i])
			return i;
		return path[i] = findSet(path[i]);
	}

}
