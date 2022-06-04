package Q3289_서로소집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] data;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 1~n까지의 정점의 개수
			int m = Integer.parseInt(st.nextToken()); // 간선의 개수

			sb = new StringBuilder("#").append(t).append(" ");
			data = new int[n + 1];

			// makeSet
			for (int i = 1; i <= n; i++)
				data[i] = i;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				if (num == 0)
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else
					sb.append(findSet(Integer.parseInt(st.nextToken())) == findSet(Integer.parseInt(st.nextToken())) ? 1
							: 0);
			}
			System.out.println(sb.toString());
		}
	}

	private static void union(int n1, int n2) {
		int px = findSet(n1);
		int py = findSet(n2);
		data[py] = px;
	}

	private static int findSet(int n) {
		if (data[n] == n) {
			return n;
		}
		return data[n] = findSet(data[n]);
	}
}
