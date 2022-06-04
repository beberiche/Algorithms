package Q1004_어린왕자;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int N = sc.nextInt();

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int r = sc.nextInt();

				if(check(x1, x, y1, y, r) != check(x2, x, y2, y, r)) 
					cnt++;
			}
			System.out.println(cnt);
		}

	}

	public static boolean check(int cx, int x, int cy, int y, int r) {
		if ((cx - x) * (cx - x) + (cy - y) * (cy - y) <= r * r) return true;
		return false;
	}
}
