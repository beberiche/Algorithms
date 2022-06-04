package Q1769_3의배수;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String[] strArr = (N + "").split("");

		if (recur(strArr)) {
			System.out.println(cnt);
			System.out.println("YES");
		} else {
			System.out.println(cnt);
			System.out.println("NO");
		}
	}

	public static Boolean recur(String[] strArr) {
		if (strArr.length == 1) {
			return Integer.parseInt(strArr[0]) % 3 == 0;
		}
		// 초기화
		int sum = 0;
		for (int i = 0; i < strArr.length; i++) {
			sum += Integer.parseInt(strArr[i]);
		}
		// 카운트 증가
		cnt++;
		// 한자리수라면 리턴
		return recur((sum + "").split(""));
	}
}
