package Q3499_퍼펙트셔플;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input3499.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			int cards = sc.nextInt();

			// 카드 중간 값 구하기
			int mid = cards % 2 == 0 ? cards / 2 : cards / 2 + 1;

			// 카드가 짝수일 경우 홀수 일 경우 모두 OK
			String[] temp = new String[mid]; // 첫번째 배열은 mid까지
			String[] temp2 = new String[cards - mid]; // 두번째 배열은 N-mid
			for (int i = 0; i < temp.length; i++)
				temp[i] = sc.next();

			for (int i = 0; i < temp2.length; i++)
				temp2[i] = sc.next();
			sc.close();

			// 큐 실행
			// 굳이 큐 안써도 되긴 함.
			Queue<String> queue = new LinkedList<>();
			for (int i = 0; i < mid; i++) {
				queue.offer(temp[i]);
				// 홀수인 경우는 중간에 멈춰주기
				if (cards % 2 == 1 && i == mid - 1)
					break;
				queue.offer(temp2[i]);
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(TC).append(" ");
			for (int i = 0; i < cards; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
			System.out.print(sb.toString());
		}
	}
}
