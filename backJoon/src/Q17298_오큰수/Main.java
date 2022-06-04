package Q17298_오큰수;

import java.util.Scanner;
import java.util.Stack;

// 오른쪽에 있는 애들중
// 자기보다 크며
// 가장 본인과 인덱스가 가까운애
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Stack<Integer> store = new Stack<>();
		Stack<Integer> ans = new Stack<>();

		ans.push(-1);
		store.push(arr[N - 1]);

		for (int i = N - 2; i >= 0; i--) {
			while (!store.isEmpty()) {
				if (store.peek() <= arr[i]) {
					store.pop();
				} else if (store.peek() > arr[i]) {
					ans.push(store.peek());
					store.push(arr[i]);
					break;
				}
			}

			if (store.isEmpty()) {
				ans.push(-1);
				store.push(arr[i]);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!ans.isEmpty()) {
			sb.append(ans.pop() + " ");
		}

		System.out.println(sb.toString());
	}
}
