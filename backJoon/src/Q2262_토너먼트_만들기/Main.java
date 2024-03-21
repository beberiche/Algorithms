package Q2262_토너먼트_만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private int N, ans = 0;
	private List<Integer> list;

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
		int curr = N;
		while (curr != 1) {
			int idx = list.indexOf(curr);
			int ret = 0;
			if (idx == 0) {
				ret = list.get(idx + 1);
			} else if (idx == list.size() - 1) {
				ret = list.get(idx - 1);
			} else {
				ret = Math.max(list.get(idx + 1), list.get(idx - 1));

			}
			ans += list.get(idx) - ret;
			list.remove(idx);
			curr--;
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(stk.nextToken()));
		}
	}
}
