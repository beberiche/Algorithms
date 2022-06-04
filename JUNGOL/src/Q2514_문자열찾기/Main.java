package Q2514_문자열찾기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int kCnt = 0;
		int iCnt = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			int fir = str.charAt(i);
			int sec = str.charAt(i + 1);
			int thr = str.charAt(i + 2);

			if (fir == 'K' && sec == 'O' && thr == 'I')
				kCnt++;
			else if (fir == 'I' && sec == 'O' && thr == 'I')
				iCnt++;
		}
		System.out.println(kCnt);
		System.out.println(iCnt);
	}
}
