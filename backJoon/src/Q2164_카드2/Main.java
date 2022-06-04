package Q2164_카드2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		int ans = 0;
		while (true) {
			if (queue.size() == 1) {
				ans = queue.poll();
				break;
			}
			queue.poll();
			queue.offer(queue.poll());
		}

		System.out.println(ans);
	}
}
