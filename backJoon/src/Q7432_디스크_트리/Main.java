package Q7432_디스크_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	private Node root;
	private StringBuilder sb = new StringBuilder();

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
		dfs(root, 0, new StringBuilder());
	}

	private void dfs(Node curr, int cnt, StringBuilder blank) {
		if (cnt >= 1) blank.append(" ");
		for (String k : curr.m.keySet()) {
			sb.append(blank).append(k).append("\n");
			dfs(curr.m.get(k), cnt + 1, new StringBuilder(blank));
		}
	}

	private void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		root = new Node();
		for (int i = 0; i < N; i++) {
			String[] a = br.readLine().split("\\\\");
			go(a, 0, root);
		}
	}

	private void go(String[] a, int idx, Node curr) {
		if (idx >= a.length) {
			return;
		}
		if (!curr.m.containsKey(a[idx])) curr.m.put(a[idx], new Node());
		go(a, idx + 1, curr.m.get(a[idx]));
	}

	private class Node {
		TreeMap<String, Node> m = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
	}
}
