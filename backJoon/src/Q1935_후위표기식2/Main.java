package Q1935_후위표기식2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String pFix = sc.next(); // postFix

		double[] arr = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextDouble();
		}

		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < pFix.length(); i++) {
			char ch = pFix.charAt(i);

			if ('A' <= ch && ch <= 'Z') {
				stack.push(arr[ch - 'A']);
			} else {
				double d1 = stack.pop();
				double d2 = stack.pop();
				switch (ch) {
				case '*': {
					stack.push(d2 * d1);
					break;
				}
				case '/': {
					stack.push(d2 / d1);
					break;
				}
				case '+': {
					stack.push(d2 + d1);
					break;
				}
				case '-': {
					stack.push(d2 - d1);
					break;
				}
				}
			}
		}
		System.out.printf("%.2f", stack.pop());

	}
}
