package 순열;

import java.util.Arrays;
import java.util.Scanner;

public class 순열 {
	static int N, R;
	static int[] data;
	static int[] sel;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 6;
		R = 3;
		data = new int[] { 1, 2, 3, 4, 5, 6 };
		sel = new int[R];
		visited = new boolean[N];

		print("반복을 이용한 순열 - 무조건 2개 뽑기");
		perm1();

		print("방문체크를 이용한 순열");
		perm2(0);

		print("방문체크를 비트마스킹으로 한 순열");
		perm3(0, 0);
		sc.close();
	}

	private static void print(String msg) {
		System.out.println("--------------------------------");
		System.out.println(msg);
		System.out.println("--------------------------------");
	}

	private static void perm1() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j || j == k || k == i)
						continue;
					System.out.println(data[i] + " " + data[j] + " " + data[k]);
				}
			}
		}
	}

	private static void perm2(int cnt) {
		if (cnt == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			sel[cnt] = data[i];
			visited[i] = true;
			perm2(cnt + 1);
			visited[i] = false;

		}
	}

	private static void perm3(int cnt, int visited) {
		if (cnt == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

//		for (int i = 0; i < N; i++) {
//			if ((visited & (1 << i)) > 0)
//				continue;
//			sel[cnt] = data[i];
//			perm3(cnt + 1, visited | 1 << i);
//		}

		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) > 0)
				continue;
			sel[cnt] = data[i];
			perm3(cnt + 1, visited | 1 << i);
		}
	}
}
