package Q2448_별찍기11;

import java.util.Scanner;

public class Main {
	static String[] star;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		star = new String[N];
		star[0] = "  *  ";
		star[1] = " * * ";
		star[2] = "*****";

		int k = 1;
		while (3 * Math.pow(2, k) <= N) {
			int currC = (int) (3 * Math.pow(2, k));

			for (int i = currC / 2, j = 0; i < currC; i++, j++) {
				star[i] = star[j] + " " + star[j];
			}

			String tempS = "";
			for (int i = 0; i < currC / 2; i++)
				tempS += " ";

			for (int i = 0; i < currC / 2; i++) {
				star[i] = tempS + star[i] + tempS;
			}
			k++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < star.length; i++) {
			sb.append(star[i] + "\n");
		}
		System.out.println(sb.toString());
	}

}
