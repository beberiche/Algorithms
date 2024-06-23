package Q1889_선물_교환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] in = new int[N + 1];
		List<Integer> list[] = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			list[i] = new ArrayList<>();
			list[i].add(n1);
			list[i].add(n2);

			in[n1]++;
			in[n2]++;
		}


		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (in[i] < 2) {
				q.add(i);
				visited[i] = true;
			}
		}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : list[curr]) {
				in[next]--;
				if (in[next] < 2 && !visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}

		int ans = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				sb.append(i).append(" ");
				ans++;
			}
		}

		System.out.println(ans);
		System.out.print(sb.toString());
	}
}
