package Q1102_스택;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Stack<Integer> stack = new Stack<>();
		while (--N >= 0) {
			char ch = sc.next().charAt(0);
			int n;
			if (ch == 'i') {
				stack.push(sc.nextInt());
			} else if(ch=='c') {
				System.out.println(stack.size());
			} else if(ch=='o') {
				if(stack.isEmpty()) {
					System.out.println("empty");
				} else {
					System.out.println(stack.pop());
				}
			}
			
		}
	}
}
