package Q4949_균형잡힌세상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String text = br.readLine();
			int len = text.length();
			// 종료조건
			if (text.charAt(0) == '.' && len == 1) {
				break;
			}

			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for (int i = 0; i < len; i++) {
				char ch = text.charAt(i);
				if (ch == '(' || ch == '[') {
					stack.push(ch);
				} else if (ch == ')' || ch == ']') {
					if (stack.size() == 0) {
						flag = false;
						break;
					}
					if ((ch == ')' && stack.peek() != '(') || (ch == ']' && stack.peek() != '[')) {
						flag = false;
						break;
					}
					stack.pop();
					if (i == len - 1) {
						break;
					}
				} else {
					continue;
				}
			}

			if (flag && stack.size() == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
