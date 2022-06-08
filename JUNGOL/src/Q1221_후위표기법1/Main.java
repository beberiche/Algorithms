package Q1221_후위표기법1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		while (--N >= 0) {
			char ch = sc.next().charAt(0);
			if (ch == '+') {
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n2 + n1);
			} else if (ch == '-') {
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n2 - n1);
			} else if (ch == '*') {
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n2 * n1);
			} else if (ch == '/') {
				int n1 = stack.pop();
				int n2 = stack.pop();
				stack.push(n2 / n1);
			} else {
				stack.push(ch - '0');
			}
		}
		
		System.out.println(stack.pop());
	}
}
