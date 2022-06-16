package Q2110_공유기설치;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int C = sc.nextInt();

		int[] home = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++)
			home[i] = sc.nextInt();

		Arrays.sort(home);

		int st = 1;
		int ed = home[N - 1] - home[0];

		while (st <= ed) {
			int mid = (st + ed) / 2;
			int cnt = 1;
			int tempSt = home[0];
			for (int i = 1; i < home.length; i++) {
				if (home[i] - tempSt >= mid) {
					cnt++;
					tempSt = home[i];
				}
			}
			if (cnt < C)
				ed = mid - 1;
			else {
				max = Math.max(max, mid);
				st = mid + 1;
			}
		}
		System.out.println(max);
	}
}
