package Q1233_사칙연산_유효성_검사;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(sc.nextLine());
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				String[] arr = sc.nextLine().split(" ");
				if (arr.length <= 2 && "*/+-".contains(arr[1])) {
					flag = true;
				}
			}

			System.out.print("#" + T + " ");
			if (flag) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}

		}
	}
}
