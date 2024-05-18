package Q1935_팀배분;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private List<Integer> list[], blue, white;
	private int visited[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		StringBuilder sb = new StringBuilder();
		sb.append(blue.size()).append("\n");
		for (int n : blue) {
			sb.append(n).append(" ");
		}
		sb.append("\n");
		sb.append(white.size()).append("\n");
		for (int n : white) {
			sb.append(n).append(" ");
		}
		System.out.print(sb.toString());
	}

	private void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		visited[num] = 1;
		q.add(num);
		while (!q.isEmpty()) {
			int curr = q.poll();

			if (visited[curr] == 1) blue.add(curr);
			else white.add(curr);

			for (int next : list[curr]) {
				if (visited[next] == 0) {
					visited[next] = visited[curr] * -1;
					q.add(next);
				}
			}
		}
	}

	private void solve() {
		blue = new ArrayList<>();
		white = new ArrayList<>();
		visited = new int[list.length + 1];
		for (int i = 1; i < list.length; i++) {
			if (visited[i] == 0) {
				bfs(i);
			}
		}

		Collections.sort(blue);
		Collections.sort(white);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(stk.nextToken());
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(stk.nextToken());
				list[i].add(num);
			}
		}
	}
}
