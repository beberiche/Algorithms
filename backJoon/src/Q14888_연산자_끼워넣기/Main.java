package Q14888_연산자_끼워넣기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Character> list;
	static char[] sel;
	static boolean[] visited;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];

		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			int temp = sc.nextInt();
			if (temp == 0)
				continue;

			comp(i, temp);
		}

		visited = new boolean[list.size()];
		sel = new char[list.size()];
		perm(0);
		System.out.println(max);
		System.out.println(min);

	}

	private static void perm(int cnt) {
		if (cnt == sel.length) {
			int result = calc();
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (visited[i])
				continue;
			sel[cnt] = list.get(i);
			visited[i] = true;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static void comp(int i, int temp) {
		switch (i) {
		case 0:
			while (--temp >= 0)
				list.add('+');
			break;
		case 1:
			while (--temp >= 0)
				list.add('-');
			break;
		case 2:
			while (--temp >= 0)
				list.add('*');
			break;
		case 3:
			while (--temp >= 0)
				list.add('/');
			break;
		}
	}

	private static int calc() {
		int sum = arr[0];

		for (int i = 0; i < sel.length; i++) {
			int tmp = sel[i];
			switch (tmp) {
			case '+':
				sum += arr[i + 1];
				break;

			case '-':
				sum -= arr[i + 1];
				break;

			case '*':
				sum *= arr[i + 1];
				break;

			case '/':
				if (sum < 0 && arr[i + 1] > 0) {
					int n = arr[i + 1] * -1;
					sum = (sum / n) * -1;
				} else {
					sum /= arr[i + 1];
				}
				break;

			}
		}

		return sum;
	}

}
