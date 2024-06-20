package Q1464_뒤집기_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Deque<Character> d = new ArrayDeque<>();
		d.add(str.charAt(0));
		for (int i = 1; i < str.length(); i++) {
			char prev = d.getLast();
			char curr = str.charAt(i);

			if (prev < curr) {
				d.addFirst(curr);
			} else {
				d.addLast(curr);
			}
		}

		StringBuilder sb = new StringBuilder();
		while(!d.isEmpty()) {
			sb.append(d.pollLast());
		}
		System.out.println(sb.toString());
	}
}
