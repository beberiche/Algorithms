package Q20164_홀수홀릭호석;

import java.util.Scanner;

public class Main {
	static int min, max;

	public static void main(String[] args) {
		String str = new Scanner(System.in).next();
		int cnt = 0;
		if (Integer.parseInt(str) > 10) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) - '0') % 2 == 1)
					cnt++;
			}
			if (Integer.parseInt(str) < 100) {
				if (cnt == 0)
					System.out.println(0 + " " + 0);
				else 
					System.out.println((cnt+2) + " " + (cnt+2));
				return;
			} else {
				recur(str, cnt);
				System.out.println(min + " " + max);
			}
		} else {
			if (Integer.parseInt(str) % 2 == 1)
				System.out.println(1 + " " + 1);
			else
				System.out.println(0 + " " + 0);
		}
	}

	private static void recur(String str, int cnt) {
		// TODO Auto-generated method stub
		if (Integer.parseInt(str) < 10) {
			max = Integer.parseInt(str)%2 == 0 ? Math.max(cnt, max) : Math.max(cnt+1, max);
			min = Integer.parseInt(str)%2 == 0 ? Math.min(cnt, min) : Math.min(cnt+1, min);
			return;
		}
		if (Integer.parseInt(str) < 100) {
			int tCnt = 0;
			int sum = 0;
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) - '0') % 2 == 1)
					tCnt++;
				sum += (str.charAt(i) - '0');
			}
			recur(sum + "", cnt + tCnt);
		}
		for (int i = 1; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				int tCnt = 0;
				int n1 = Integer.parseInt(str.substring(0, i));
				int n2 = Integer.parseInt(str.substring(i, j));
				int n3 = Integer.parseInt(str.substring(j, str.length()));
				int temp = n1 + n2 + n3;
				if(temp >= 100) {
					for (int d = 0; d < (temp+"").length(); d++) {
						if (((temp+"").charAt(d) - '0') % 2 == 1)
							tCnt++;
					}
					recur(temp+"", cnt+tCnt);
				} else {
					recur(temp+"", cnt);
				}				
			}
		}
	}
}