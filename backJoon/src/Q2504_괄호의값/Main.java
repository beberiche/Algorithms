package Q2504_괄호의값;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> stack = new Stack<>();

		int mul = 1;
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				mul *= 2;
				stack.add(ch);
			} else if (ch == '[') {
				mul *= 3;
				stack.add(ch);
			} else if (!stack.isEmpty() && ch == ')') {
				if (i - 1 >= 0 && str.charAt(i - 1) == '(') {
					sum += mul;
				} else {
					if (stack.peek() != '(') {
						sum = 0;
						break;
					}
				}
				mul /= 2;
				stack.pop();
			} else if (!stack.isEmpty() && ch == ']') {
				if (i - 1 >= 0 && str.charAt(i - 1) == '[') {
					sum += mul;
				} else {
					if (stack.peek() != '[') {
						sum = 0;
						break;
					}
				}
				mul /= 3;
				stack.pop();
			} else {
				sum = 0;
				break;
			}
		}

		if (!stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(sum);
		}
	}
}
