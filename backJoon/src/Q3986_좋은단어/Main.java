package Q3986_좋은단어;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			char[] charArr = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();

			for (int j = 0; j < charArr.length; j++) {
				if (!stack.isEmpty() && stack.peek() == charArr[j]) {
					stack.pop();
					continue;
				}
				stack.add(charArr[j]);
			}

			if (stack.isEmpty())
				cnt++;

		}
		System.out.println(cnt);
	}
}
