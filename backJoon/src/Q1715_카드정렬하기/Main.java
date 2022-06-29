package Q1715_카드정렬하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));

		int sum = 0;
		while (pq.size() > 1) {
			int temp = pq.poll()+pq.poll();
			sum += temp;
			pq.add(temp);
		}
		System.out.println(sum);
	}
}
