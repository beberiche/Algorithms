package Q1874_스택수열;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();

		int st = 0;
		while (--N >= 0) {
			int n = sc.nextInt();

			if (n > st) {
				for (int i = st + 1; i <= n; i++) {
					stack.push(i);
					sb.append('+').append("\n");
				}
				st = n;
			} else if (stack.peek() != n) {
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append('-').append("\n");
		}

		System.out.println(sb.toString());
	}
}
