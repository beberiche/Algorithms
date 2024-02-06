package Q20924_트리의_기둥과_가지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, R, P, B;
	private List<int[]> list[];
	private boolean[] visited;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(P + " " + B);
	}

	private void solve() {
		visited = new boolean[N + 1];
		int node = getPillarSize();
		getBranchSize(node, 0);
	}

	private void getBranchSize(int node, int dist) {
		visited[node] = true;

		if (list[node].size() == 1) {
			B = Math.max(B, dist);
			return;
		}

		for (int[] next : list[node]) {
			if (!visited[next[0]]) {
				getBranchSize(next[0], dist + next[1]);
			}
		}
	}

	private int getPillarSize() {
		// 루트 노드 혼자이거나, 루트 노드가 기둥을 제외하고 가지와 바로 연결된 경우.
		// 가지 찾기 바로 진행.
		if (list[R].size() == 0 || list[R].size() > 1) {
			return R;
		}

		// 기둥이 존재하는 경우
		int node = list[R].get(0)[0];
		P = list[R].get(0)[1];
		visited[R] = true;
		while (list[node].size() == 2) {
			visited[node] = true;
			for (int[] next : list[node]) {
				if (!visited[next[0]]) {
					node = next[0];
					P += next[1];
				}
			}
		}

		return node;
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			int dist = Integer.parseInt(stk.nextToken());

			list[n1].add(new int[]{n2, dist});
			list[n2].add(new int[]{n1, dist});
		}
	}
}
