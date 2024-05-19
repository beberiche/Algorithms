package Q17073_나무_위의_빗물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private double W;
	private int leaf, cnt[];

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(W / leaf);
	}

	private void solve() {

	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		W = Double.parseDouble(stk.nextToken());

		cnt = new int[N + 1];
		leaf = N - 1;
		for (int i = 0; i < N - 1; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());

			cnt[n1]++;
			if (n1 != 1 && cnt[n1] == 2) leaf--;
			cnt[n2]++;
			if (n2 != 1 && cnt[n2] == 2) leaf--;
		}
	}
}