package Q5532_방학_숙제;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (C * i >= A && D * i >= B) {
				ans = N - i;
				break;
			}
		}
		System.out.println(ans);
	}
}
