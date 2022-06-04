package Q11866_요세푸스문제0;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		// 입력
		for (int i = 1; i <= N; i++)
			queue.add(i);

		StringBuilder sb = new StringBuilder();

		// 3명씩 돌아가며 살해, size =0 이면 탈출
		int r = 1;
		sb.append("<");
		while (queue.size() != 0) {
			if (r == K) {
				sb.append(queue.poll()).append(", ");
				r = 1;
				continue;
			}
			queue.add(queue.poll());
			r++;
		}
		sb.deleteCharAt(sb.lastIndexOf(",")).deleteCharAt(sb.lastIndexOf(" "));
		sb.append(">");
		System.out.println(sb);
	}
}
