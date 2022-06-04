package Q8959_OX퀴즈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	for (int TC = 0; TC < T; TC++) {
	    String str = sc.next();
	    int sum = 0; // 점수 총합
	    int bonus = 0; // 연속 득점 시 누적
	    for (int i = 0; i < str.length(); i++) {
		bonus = str.charAt(i) == 'O' ? bonus += 1 : 0;
		sum += bonus;
	    }
	    System.out.println(sum);
	}
    }
}
