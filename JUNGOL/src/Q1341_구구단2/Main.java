package Q1341_구구단2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int st = sc.nextInt();
		int ed = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		if (st < ed) {
			for (int i = st; i <= ed; i++) {
				for (int j = 1; j <= 9; j++) {
					sb.append(i).append(" * ").append(j).append(" = ")
							.append(i * j / 10 == 0 ? " " + i * j : i * j);
					if (j % 3 == 0)
						sb.append("\n");
					else 
						sb.append("   ");
				}
				sb.append("\n");
			}
		} else {
			for (int i = st; i >= ed; i--) {
				for (int j = 1; j <= 9; j++) {
					sb.append(i).append(" * ").append(j).append(" = ")
							.append(i * j / 10 == 0 ? " " + i * j : i * j);
					if (j % 3 == 0)
						sb.append("\n");
					else 
						sb.append("   ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
