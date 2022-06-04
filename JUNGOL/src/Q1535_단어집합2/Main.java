package Q1535_단어집합2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "";
		while (true) {
			String str = sc.nextLine();
			if (str.equals("END")) {
				break;
			}
			String[] arr = str.split(" ");

			for (String s : arr) {
				String[] temp = ans.split(" ");
				boolean check = true;
				for(String s2: temp) {
					if(s.equals(s2)) {
						check = false;
						break;
					}
				}
				if(check) {
					ans += s + " ";
				}
			}
			System.out.println(ans.trim());
		}

	}
}
