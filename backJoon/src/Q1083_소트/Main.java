package Q1083_소트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private int N, S;
	private List<Integer> list;
	private StringBuilder sb;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.print(sb.toString());
	}

	private void solve() {
		int st = 0;
		while (st < N && S != 0) {
			int max = list.get(st);
			int maxIdx = st;
			for (int i = st + 1; i < N; i++) {
				if (max < list.get(i) && i - st <= S) {
					max = list.get(i);
					maxIdx = i;
				}
				if (i - st > S) {
					break;
				}
			}

			if (maxIdx != st) {
				int next = list.get(maxIdx);
				list.remove(maxIdx);
				list.add(st, next);
				S -= (maxIdx - st);
			}
			st++;
		}

		sb = new StringBuilder();
		for (int n : list) {
			sb.append(n).append(" ");
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new LinkedList<>();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(stk.nextToken()));
		}

		S = Integer.parseInt(br.readLine());
	}
}