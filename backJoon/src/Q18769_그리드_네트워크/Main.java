package Q18769_그리드_네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (--T >= 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());

			int[][] a = new int[N][M];

			int idx = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					a[i][j] = idx++;
				}
			}

			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < M - 1; j++) {
					list.add(new int[]{a[i][j], a[i][j + 1], Integer.parseInt(stk.nextToken())});
				}
			}

			for (int i = 0; i < N - 1; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					list.add(new int[]{a[i][j], a[i + 1][j], Integer.parseInt(stk.nextToken())});
				}
			}

			int p[] = new int[idx + 1];
			for (int i = 1; i <= idx; i++) {
				p[i] = i;
			}
			int cnt = 0;
			int ans = 0;
			Collections.sort(list, (n1, n2) -> n1[2] - n2[2]);

			for (int i = 0; i < list.size(); i++) {
				if (cnt >= idx - 1) {
					break;
				}

				int[] curr = list.get(i);
				int f1 = find(curr[0], p);
				int f2 = find(curr[1], p);

				if (f1 == f2) continue;

				if (f1 > f2) {
					int tmp = f1;
					f1 = f2;
					f2 = tmp;
				}

				p[f2] = f1;
				ans += curr[2];
				cnt++;
			}

			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static int find(int node, int[] p) {
		if (p[node] == node) return node;
		return p[node] = find(p[node], p);
	}
}
