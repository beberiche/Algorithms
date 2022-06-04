package Q1475_방번호;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] number = sc.next().split("");

		String set = "012345#78#";

		// 일단 하나 사고 시작
		int cnt = 1;
		for (int i = 0; i < number.length; i++) {
			if (set.contains(number[i])) {
				set = set.replaceFirst(number[i], ".");
			} else {
				// 6대신 9를 쓴 경우
				if ((number[i].equals("6") || number[i].equals("9")) && set.contains("#")) {
					set = set.replaceFirst("#", ".");
				} else {
					cnt++;
					set += "012345#78#";
					i--;
				}
			}
		}
		System.out.println(cnt);
	}
}
