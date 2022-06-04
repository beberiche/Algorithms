package Q5432_쇠막대기_자르기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input5432.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {

			String stick = br.readLine();
			Stack<Character> stack = new Stack<>();
			int amount = 0; // 막대기의 양
			for (int i = 0; i < stick.length(); i++) {
				if (stick.charAt(i) == '(')
					stack.push(stick.charAt(i));
				else {
					if (stick.charAt(i - 1) == '(') { // 레이저인 경우이다.
						stack.pop(); // 넣었던거 다시 빼고
						amount += stack.size(); // 지금까지 넣어둔 막대기 만큼 추가해준다.
						continue;
					}
					stack.pop(); // 막대기의 끝이라면
					amount += 1; // 하나 추가해주자.
				}
			}

			System.out.printf("#%d %d\n", t, amount);
		}
	}
}
