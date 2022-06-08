package Q2858_쇠막대기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] arr = sc.next().toCharArray();
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(arr[i]);
			} else {
				if(arr[i-1]=='(') {
					stack.pop();
					ans += stack.size();
				} else {
					stack.pop();
					ans+=1;
				}
			}
		}
		System.out.println(ans);
	}
}
