package Q11899_괄호끼워넣기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] charArr = sc.next().toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < charArr.length; i++) {
			char ch = charArr[i];

			if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
				stack.pop();
				continue;
			} else {
				stack.add(ch);
			}
		}
		System.out.println(stack.size());
	}
}
