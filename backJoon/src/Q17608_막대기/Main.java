package Q17608_막대기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			stack.push(sc.nextInt());
		}

		int root = stack.pop();
		int maxH = root;
		int visible = 1;
		while (!stack.isEmpty()) {
			int curH = stack.pop();
			if (curH > root && curH > maxH) {
				visible++;
			}
			maxH = Math.max(curH, maxH);
		}

		System.out.println(visible);

	}
}
