package Q2491_수열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.nextLine();

		int max = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		int check = 1;
		for (int i = 0; i < N - 1; i++) {
			if (check == 1) {
				if (str.charAt(i) >= str.charAt(i + 1)) {
					cnt2++;
				}
			} else {

			}
		}
	}
}
