package Q1697_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		while (--N >= 0) {
			char ch = sc.next().charAt(0);
			if (ch == 'i') {
				q.add(sc.nextInt());
			} else if (ch == 'c') {
				System.out.println(q.size());
			} else {
				if (q.isEmpty()) {
					System.out.println("empty");
				} else {
					System.out.println(q.poll());
				}
			}
		}
	}
}
