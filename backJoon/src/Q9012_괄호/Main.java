package Q9012_괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		outer: for (int i = 0; i < N; i++) {
			char[] arr = sc.next().toCharArray();

			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(') {
					stack.push(arr[j]);
				} else {
					if (stack.isEmpty()) {
						System.out.println("NO");
						continue outer;
					}
					stack.pop();
				}
			}

			if (!stack.isEmpty()) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
