package Q2527_직사각형;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 0; T < 4; T++) {
			// 처음 사각형
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			// 두번째 사각형
			int r3 = sc.nextInt();
			int c3 = sc.nextInt();
			int r4 = sc.nextInt();
			int c4 = sc.nextInt();

			if (r1 > r4 || c2 < c3 || r2 < r3 || c4 < c1) {
				System.out.println("d");
			} else if ((r1 == r4 && c1 == c4) || (r2 == r3 && c2 == c3) || (r1 == r4 && c2 == c3)
					|| (r2 == r3 && c1 == c4)) {
				System.out.println("c");
			} else if (r1 == r4 || r2 == r3 || c2 == c3 || c1 == c4) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
		}
	}
}
