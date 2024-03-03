package Q23326_홍익_투어리스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringTokenizer stk;
	private int N, M, pos;
	private TreeSet<Integer> s;
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

	private void solve() throws Exception {
		pos = 1;
		sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(stk.nextToken());
			if (cmd == 1) {
				int idx = Integer.parseInt(stk.nextToken());
				goOne(idx);
			} else if (cmd == 2) {
				int move = Integer.parseInt(stk.nextToken()) % N;
				goTwo(move);
			} else {
				goThree();
			}
		}

	}

	private void goThree() {
		Integer hi = s.ceiling(pos);
		Integer lo = s.ceiling(1);

		int ret;
		if (hi == null && lo == null) {
			ret = -1;
		} else if (hi != null) {
			ret = hi - pos;
		} else {
			ret = N - pos + lo;
		}
		sb.append(ret).append("\n");
	}

	private void goTwo(int move) {
		pos += move;
		if (pos > N) pos %= N;
	}

	private void goOne(int idx) {
		if (s.contains(idx)) s.remove(idx);
		else s.add(idx);
	}

	private void input() throws Exception {
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		s = new TreeSet<>();
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(stk.nextToken());
			if (num == 1) s.add(i);
		}
	}
}
