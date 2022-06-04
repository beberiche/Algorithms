package Q1158_요세푸스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<>();

		int N = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		System.out.print("<");

		while (!queue.isEmpty()) {
			for (int i = 1; i < M; i++) {
				queue.offer(queue.poll());
			}
			if (queue.size() == 1) {
				System.out.print(queue.poll());
			} else {
				System.out.print(queue.poll() + ", ");
			}

		}
		System.out.print(">");
	}
}
