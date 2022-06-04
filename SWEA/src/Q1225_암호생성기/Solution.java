package Q1225_암호생성기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ans = 0;
		for (int TC = 1; TC <= 10; TC++) {
			// 입력 버리기
			br.readLine();

			// 입력
			Queue<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 8; i++)
				q.offer(Integer.parseInt(st.nextToken()));

			// 사이클 반복
			// 단 한 숫자라도 0이나 0보다 작은 수가 나오면 종료되도록
			outer: while (true) {
				for (int i = 1; i <= 5; i++) {
					int n = q.poll() - i;
					if (n <= 0) {
						n = 0;
						q.offer(n);
						break outer;
					}
					q.offer(n);
				}
			}

			// 출력
			System.out.printf("#%d ", TC);
			while (q.size() > 0) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
