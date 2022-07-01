package Q1043_거짓말;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		// 진실을 아는 사람의 수
		int R = sc.nextInt();
		
		if (R == 0) {
			System.out.println(M);
			return;
		}
		
		int[] p = new int[N + 1];
		int rootNum = sc.nextInt();
		p[rootNum] = rootNum;

		for (int i = 1; i <= N; i++)
			p[i] = i;

		for (int i = 0; i < R - 1; i++)
			p[sc.nextInt()] = rootNum;

		ArrayList<Integer> List[] = new ArrayList[M];

		for (int i = 0; i < M; i++) {
			int currP = sc.nextInt();
			List[i] = new ArrayList<>();
			for (int j = 0; j < currP; j++)
				List[i].add(sc.nextInt());
		}

		for (int k = 0; k < M; k++) {
			for (int i = 0; i < M; i++) {
				for (int n1 : List[i]) {
					if (p[n1] == rootNum) {
						for (int n2 : List[i])
							p[n2] = rootNum;
						break;
					}
				}
			}
		}

		int ans = 0;
		outer: for (int i = 0; i < M; i++) {
			for (int n : List[i])
				if (p[n] == rootNum)
					continue outer;
			ans++;
		}
		System.out.println(ans);
	}
}
