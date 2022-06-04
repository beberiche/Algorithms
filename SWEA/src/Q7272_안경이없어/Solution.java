package Q7272_안경이없어;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input7272.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			// 구멍0개로 보이는 값을 모두 한단어로 통일
			// 구멍1개로 보이는 값을 모두 한단어로 통일
			// 구멍2개는 단어가 하나이니 굳이 건드릴 필요도 없음
			String str1 = sc.next().replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "C").replaceAll("[ADOPQR]", "A");
			String str2 = sc.next().replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "C").replaceAll("[ADOPQR]", "A");
			System.out.printf("#%d %s\n", TC, str1.equals(str2) ? "SAME" : "DIFF");
		}
	}
}
