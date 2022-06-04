package Q17952_과제는끝나지않아;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int min = sc.nextInt();

		Stack<List<Integer>> stack = new Stack<>();
		int sum = 0;
		int cnt = 0;
		for (int i = min; i > 0; i--) {
			if (sc.nextInt() != 0) {
				int score = sc.nextInt();
				cnt = sc.nextInt() - 1;
				if (cnt == 0) {
					sum += score;
				} else {
					stack.push(Arrays.asList(score, cnt));
				}
			} else {
				if (!stack.isEmpty()) {
					List<Integer> list = stack.pop();
					int n1 = list.get(0);
					int n2 = list.get(1) - 1;
					if (n2 == 0) {
						sum += n1;
					} else {
						stack.push(Arrays.asList(n1, n2));
					}
				}
			}
		}
		sc.close();
		System.out.println(sum);

	}
}
