package Q3106_진법변환;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int num1 = sc.nextInt();
			if (num1 == 0)
				break;

			char[] num2 = sc.next().toCharArray();

			// A -> 10
			long changeNum2 = 0;
			for (int i = 0; i < num2.length; i++) {
				if (Character.isDigit(num2[i]))
					changeNum2 = changeNum2 * num1 + (num2[i] - '0');
				else
					changeNum2 = changeNum2 * num1 + (num2[i] - 'A' + 10);
			}

			// 10 -> B
			int num3 = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			while (changeNum2 > 0) {
				if (changeNum2 % num3 < 10)
					sb.append(changeNum2 % num3);
				else
					sb.append((char) (changeNum2 % num3 - 10 + 'A'));
				changeNum2 /= num3;
			}
			System.out.println(sb.toString().equals("") ? 0 : sb.reverse());
		}
	}
}
