package Q11509_풍선_맞추기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int N, a[], ans;
	private HashMap<Integer, Integer> m;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.output();
	}

	private void output() {
		System.out.println(ans);
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int INF = (int) 1e6 + 4;
		a = new int[INF];
		m = new HashMap<>();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(stk.nextToken());
			if (m.containsKey(num + 1) && m.get(num + 1) > 0) {
				m.put(num + 1, m.get(num + 1) - 1);
			} else {
				ans++;
			}
			m.put(num, m.getOrDefault(num, 0) + 1);
		}
	}
}
