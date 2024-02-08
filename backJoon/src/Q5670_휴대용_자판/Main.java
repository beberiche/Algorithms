package Q5670_휴대용_자판;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num;
		Node root;
		String a[];
		StringBuilder sb = new StringBuilder();
		while ((num = br.readLine()) != null) {
			int N = Integer.parseInt(num);
			root = new Node(null);
			a = new String[N];
			for (int i = 0; i < N; i++) {
				a[i] = br.readLine();
				insert(a[i], 0, root);
			}
			double ret = 0;
			for (int i = 0; i < N; i++) {
				ret += find(a[i], 0, root, 0);
			}
			sb.append(String.format("%.2f\n", ret / N));
		}
		System.out.print(sb.toString());
	}

	private static int find(String str, int idx, Node curr, int cnt) {
		if (idx >= str.length()) {
			return cnt;
		}
		char key = str.charAt(idx);

		Node next = curr.m.get(key);
		if (curr.ch != null && !curr.isEnd && curr.m.size() == 1) {
			return find(str, idx + 1, next, cnt);
		} else {
			return find(str, idx + 1, next, cnt + 1);
		}
	}


	private static void insert(String str, int idx, Node curr) {
		if (idx >= str.length()) {
			curr.isEnd = true;
			return;
		}
		char key = str.charAt(idx);
		if (!curr.m.containsKey(key)) curr.m.put(key, new Node(key));
		Node next = curr.m.get(key);
		insert(str, idx + 1, next);
	}

	private static class Node {
		Character ch;
		Map<Character, Node> m;
		boolean isEnd;

		Node(Character ch) {
			this.ch = ch;
			m = new HashMap<>();
		}
	}
}
