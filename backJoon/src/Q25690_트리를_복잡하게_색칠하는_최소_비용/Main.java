package Q25690_트리를_복잡하게_색칠하는_최소_비용;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N;
	private long a[][];
	private List<Integer> g[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(Math.min(a[0][0], a[0][1]));
	}

	private void solve() {
		go(0);
	}

	private void go(int curr) {
		for (int next : g[curr]) {
			go(next);
			a[curr][0] += Math.min(a[next][0], a[next][1]);
			a[curr][1] += a[next][0];
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		g = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			g[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			g[Integer.parseInt(stk.nextToken())].add(Integer.parseInt(stk.nextToken()));
		}

		a = new long[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			a[i][0] = Integer.parseInt(stk.nextToken());
			a[i][1] = Integer.parseInt(stk.nextToken());
		}
	}
}
