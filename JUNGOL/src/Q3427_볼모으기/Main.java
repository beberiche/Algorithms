package Q3427_볼모으기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();

		int rCnt = 0;
		int bCnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'R') {
				rCnt++;
			} else {
				bCnt++;
			}
		}

		int minN = 987654321;

		int cnt = 0;
		int idx = 0;
		while (str.charAt(idx++) == 'R')
			cnt++;
		minN = Math.min(minN, rCnt - cnt);

		cnt = 0;
		idx = str.length() - 1;
		while (str.charAt(idx--) == 'R')
			cnt++;
		minN = Math.min(minN, rCnt - cnt);

		cnt = 0;
		idx = 0;
		while (str.charAt(idx++) == 'B')
			cnt++;
		minN = Math.min(minN, bCnt - cnt);
		
		cnt = 0;
		idx = str.length()-1;
		while (str.charAt(idx--) == 'B')
			cnt++;
		minN = Math.min(minN, bCnt - cnt);
		
		System.out.println(minN);

	}
}
