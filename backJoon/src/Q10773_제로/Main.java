package Q10773_제로;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n != 0) {
				stack.push(n);
			} else {
				stack.pop();
			}
		}

		int sum = 0;
		for (int n : stack)
			sum += n;

		System.out.println(sum);
	}
}
