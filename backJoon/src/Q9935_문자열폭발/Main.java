package Q9935_문자열폭발;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Character> str = new ArrayList<>();
		List<Character> bStr = new ArrayList<>();
		Stack<Character> stack = new Stack<>();

		for (char c : sc.next().toCharArray())
			str.add(c);

		for (char c : sc.next().toCharArray())
			bStr.add(c);

		for (int i = 0; i < str.size(); i++) {
			stack.push(str.get(i));

			if (stack.size() >= bStr.size() && stack.peek() == bStr.get(bStr.size() - 1)) {
				boolean flag = true;
				for (int j = 0; j < bStr.size() - 1; j++) {
					if (stack.get(stack.size() - bStr.size() + j) != bStr.get(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < bStr.size(); j++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack)
			sb.append(c);

		System.out.println(sb.toString().equals("") ? "FRULA" : sb.toString());
	}
}