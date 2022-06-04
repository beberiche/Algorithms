package Q1759_암호만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C; // 암호의 수, 주어진 문자의 수
	static char[] letter;
	static final String vowel = "aeiou";
	static char[] sel;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		L = sc.nextInt();
		C = sc.nextInt();
		letter = new char[C];
		for (int i = 0; i < C; i++) {
			letter[i] = sc.next().charAt(0);
		}
		// 미리 정렬을 해준 후 조합을 구하면
		// 알아서 정렬된 암호가 나올 것!
		Arrays.sort(letter);
		sel = new char[L];
		sb = new StringBuilder();
		comb(0, 0);
		System.out.println(sb.toString());
	}

	public static void comb(int cnt, int st) {
		if (cnt == L) {
			// 암호 조건 확인하기
			if (checkString()) {
				sb.append(Arrays.toString(sel).replace("[", "").replace(",", "").replace("]", "").replace(" ", ""));
				sb.append("\n");
			}
			return;
		}

		for (int i = st; i < C; i++) {
			sel[cnt] = letter[i];
			comb(cnt + 1, i + 1);
		}

	}

	public static boolean checkString() {
		int cnt1 = 0; // 모음 확인용
		int cnt2 = 0; // 자음 확인용
		for (int i = 0; i < sel.length; i++) {
			// 모음이라면 모음++
			if (vowel.contains(String.valueOf(sel[i]))) {
				cnt1++;
				// 모음이 아니면 자음이니까 자음++
			} else {
				cnt2++;
			}
			// 해당 조건 충족 여부
			if (cnt1 >= 1 && cnt2 >= 2)
				return true;
		}
		// 여기까지 왔다면 조건 충족 못한 것!
		return false;
	}
}
