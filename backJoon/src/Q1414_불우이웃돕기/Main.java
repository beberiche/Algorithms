package Q1414_불우이웃돕기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	private int N, p[], sum, ans = -1;
	private List<int[]> edges;

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
		Collections.sort(edges, (n1, n2) -> n1[2] - n2[2]);

		int cnt = 0;
		int ret = 0;
		for (int i = 0; i < edges.size(); i++) {
			int[] curr = edges.get(i);
			int x = find(curr[0]);
			int y = find(curr[1]);

			if (x != y) {
				if (x < y) {
					p[y] = x;
				} else {
					p[x] = y;
				}
				cnt++;
				ret += curr[2];
			}

			if (cnt == N - 1) {
				break;
			}
		}

		if (cnt == N - 1) {
			ans = sum - ret;
		}
	}

	private int find(int n) {
		if (n == p[n]) return n;
		return p[n] = find(p[n]);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		edges = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		p = new int[N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			p[i] = i;
			for (int j = 0; j < str.length(); j++) {
				int ch = str.charAt(j);

				if (ch == '0') continue;

				if (ch >= 'a') ch -= 'a';
				else {
					ch -= 'A';
					ch += 26;
				}

				ch++;
				sum += ch;

				edges.add(new int[]{i, j, ch});
			}
		}
	}
}
