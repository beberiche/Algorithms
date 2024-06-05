package Q16934_게임_닉네임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Trie root = new Trie(null);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String ret = go(br.readLine(), 0, root, false, "");
			sb.append(ret).append("\n");
		}
		System.out.print(sb.toString());
	}

	private static String go(String str, int idx, Trie t, boolean is_pick, String nick) {
		if (idx >= str.length()) {
			t.cnt++;
			if (!is_pick) return t.cnt == 1 ? nick : nick + t.cnt;
			return nick;
		}

		char c = str.charAt(idx);
		boolean check = is_pick;
		String new_nick = check ? nick : nick + c;

		if (!t.m.containsKey(c)) {
			Trie new_t = new Trie(c);
			t.m.put(c, new_t);
			if (!is_pick) check = true;
		}

		return go(str, idx + 1, t.m.get(c), check, new_nick);
	}

	private static class Trie {
		Character curr;
		HashMap<Character, Trie> m;
		int cnt;

		Trie(Character curr) {
			this.curr = curr;
			m = new HashMap<>();
		}
	}
}