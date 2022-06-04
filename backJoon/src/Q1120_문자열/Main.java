package Q1120_문자열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();

		String T = ""; // 본문
		String P = ""; // 패턴

		// 본문, 패턴 정하기 (더 긴게 본분, 짧은게 패턴)
		if (str1.length() >= str2.length()) {
			T = str1;
			P = str2;
		} else {
			T = str2;
			P = str1;
		}

		int len = P.length(); // 바꾸기 전 패턴의 본래 글자 수
		int diff = T.length() - P.length(); // 차이 구하기

		// 본문과 길이가 똑같아지도록
		// P에 글자 붙이기
		for (int i = 1; i <= diff; i++)
			P += "#";

		StringBuilder sb = new StringBuilder(P);

		int min = 50; // 최대 50글자이기 때문에 50개 보다 더 많이 틀릴 수는 없음
		int curLen = len; // 기존 글자 수 가져오기.
		if (diff > 0) { // 글자수가 서로 안맞는 경우에는 글자 수 차이만큼 (diff)
						// 반복하기
			for (int i = 0; i <= diff; i++) {
				int cnt = 0;
				for (int j = i; j < curLen; j++) {
					if (sb.charAt(j) != T.charAt(j))
						cnt++;
				}
				min = Math.min(min, cnt);
				sb.deleteCharAt(sb.lastIndexOf("#")); // 패턴 글자 이동 "abc#"
				sb.insert(0, "#"); // "#abc"
				curLen++;
			}
		} else { // 글자수가 서로 맞는 경우 그냥 반복문 한번만 해주면 끝!
			int cnt = 0;
			for (int j = 0; j < curLen; j++) {
				if (sb.charAt(j) != T.charAt(j))
					cnt++;
			}
			min = Math.min(min, cnt);
		}

		System.out.println(min);
	}
}
