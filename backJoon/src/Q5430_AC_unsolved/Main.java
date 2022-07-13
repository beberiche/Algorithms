package Q5430_AC_unsolved;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		StringBuilder ans = new StringBuilder();
		outer: while (--T >= 0) {
			String func = sc.next();
			sc.nextInt();
			StringBuilder sb = new StringBuilder(sc.next());
			if (func.contains("RR")) {
				func = func.replace("RR", "");
			}
			for (int i = 0; i < func.length(); i++) {
				char temp = func.charAt(i);
				if (temp == 'R') {
					String tempStr = "";
					String tempStr2 = "";
					for(int j=0; j<sb.length(); j++) {
						char font = sb.charAt(j);
						if(font == ',' || font ==']') {
							tempStr = tempStr2 + "," + tempStr;
							tempStr2 ="";
						} else if (font != '[' && font != ']') {
							tempStr2 += font;
						}
					}
					sb = new StringBuilder();
					sb = sb.append("[").append(tempStr.substring(0, tempStr.length()-1)).append("]");
				} else if (temp == 'D') {
					for(int j=0; j<sb.length(); j++) {
						char font = sb.charAt(j);
						if(font == ',' || font == ']') {
							sb = new StringBuilder("["+ sb.substring(j+1, sb.length()).toString());
							break;
						}
					}
					if(sb.length() <= 2) {
						sb = new StringBuilder("error");
					}
				}
			}
			ans.append(sb).append("\n");
		}
		System.out.println(ans);
	}
}