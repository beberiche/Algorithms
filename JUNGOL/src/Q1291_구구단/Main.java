package Q1291_구구단;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			if (n1 < 2 || n1 > 9 || n2 < 2 || n2 > 9) {
				System.out.println("INPUT ERROR!");
			} else if (n1 < n2) {
				for (int k = 1; k <= 9; k++) {
					for (int i = n1; i <= n2; i++) {
						sb.append(i).append(" * ").append(k).append(" =")
								.append((i * k) / 10 == 0 ? "  " + i * k : " " + i * k)
								.append("   ");
					}
					sb.append("\n");
				}
				System.out.println(sb.toString());
				break;
			} else {
				for (int k = 1; k <= 9; k++) {
					for (int i = n1; i >= n2; i--) {
						sb.append(i).append(" * ").append(k).append(" =")
								.append((i * k) / 10 == 0 ? "  " + i * k : " " + i * k)
								.append("   ");
					}
					sb.append("\n");
				}
				System.out.println(sb.toString());
				break;
			}
		}
	}
}
