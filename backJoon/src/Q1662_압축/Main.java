package Q1662_압축;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();

		Stack<Integer> length = new Stack();
		Stack<Integer> mul = new Stack();

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				mul.add(arr[i - 1] - '0');
				length.add(--cnt);
				cnt = 0;
			} else if (arr[i] == ')') {
				cnt = mul.pop()*cnt + length.pop();
			} else {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}