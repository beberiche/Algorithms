package Q12605_단어순서뒤집기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			String[] strArr = br.readLine().split(" ");

			Stack<String> stack = new Stack<>();

			for (int i = 0; i < strArr.length; i++) {
				stack.push(strArr[i]);
			}

			System.out.printf("Case #%d: ", TC);
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
	}
}
