package Q24230_트리_색칠하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, a[], ans;
	private List<Integer> list[];
	private boolean visited[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private void solve() {
		visited = new boolean[N];
		if (a[0] != 0) ans++;
		go(0, a[0]);
	}

	private void go(int idx, int color) {
		visited[idx] = true;

		for (int next : list[idx]) {
			if (visited[next]) continue;

			int c = color;
			if (a[next] != c) {
				c = a[next];
				ans++;
			}
			go(next, c);
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken()) - 1;
			int n2 = Integer.parseInt(stk.nextToken()) - 1;

			list[n1].add(n2);
			list[n2].add(n1);
		}
	}
}
