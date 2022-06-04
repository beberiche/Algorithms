package Q1880_암호풀기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		Map<Character, Character> map = new HashMap<>();
		char curr = 'a';
		char curr2 = 'A';
		for (int i = 0; i < 26; i++) {
			map.put(curr++, str.charAt(i));
			map.put(curr2++, Character.toUpperCase(str.charAt(i)));
		}

		map.put(' ', ' ');

		String ans = "";
		char[] replaceStr = sc.nextLine().toCharArray();

		for (char ch : replaceStr) {
			ans += map.get(ch);
		}
		System.out.println(ans);
	}
}
