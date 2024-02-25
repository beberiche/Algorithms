package Q4256_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] preOrder, inOrder;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private StringBuilder sb;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.go();
	}

	private void go() throws Exception {
		int T = Integer.parseInt(br.readLine());

		while (--T >= 0) {
			input();
			solve();
			output();
		}
	}

	private void output() {
		System.out.println(sb.toString());
	}

	private void solve() {
		sb = new StringBuilder();
		postOrder(0, 0, preOrder.length - 1);
	}


	private void postOrder(int pIdx, int st, int ed) {

		for (int i = st; i <= ed; i++) {
			if (preOrder[pIdx] == inOrder[i]) {
				int left = pIdx + 1;
				int right = pIdx + i - st + 1;
				postOrder(left, st, i - 1);
				postOrder(right, i + 1, ed);
				sb.append(inOrder[i]).append(" ");
				break;
			}
		}
	}


	private void input() throws Exception {
		int N = Integer.parseInt(br.readLine());
		preOrder = new int[N];
		inOrder = new int[N];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			preOrder[i] = Integer.parseInt(stk.nextToken());
		}

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(stk.nextToken());
		}
	}
}
