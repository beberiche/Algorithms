package Q14696_딱지놀이;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int N = sc.nextInt();

	for (int i = 0; i < N; i++) {
	    int A = sc.nextInt();
	    char[] temp = sc.nextLine().replaceAll(" ", "").toCharArray();
	    String cardsA = reverseSorting(temp);

	    int B = sc.nextInt();
	    temp = sc.nextLine().replaceAll(" ", "").toCharArray();
	    String cardsB = reverseSorting(temp);

	    String winner = " ";
	    if (A <= B) {
		winner = playGame(cardsA, cardsB);
		if (winner == "small") {
		    System.out.println('A');
		} else if (winner == "big") {
		    System.out.println('B');
		} else {
		    System.out.println('D');
		}
	    } else {
		winner = playGame(cardsB, cardsA);
		if (winner == "big") {
		    System.out.println('A');
		} else if (winner == "small") {
		    System.out.println('B');
		} else {
		    System.out.println('D');
		}
	    }

	}
    }

    public static String reverseSorting(char[] temp) {
	Arrays.sort(temp);
	return new String(new StringBuilder(new String(temp)).reverse());
    }

    public static String playGame(String small, String big) {
	int n = small.length();
	int idx = 0;
	String winner = "";
	while (--n >= 0) {
	    if (small.charAt(idx) - '0' > big.charAt(idx) - '0') {
		winner = "small";
		break;
	    }
	    if (small.charAt(idx) - '0' < big.charAt(idx) - '0') {
		winner = "big";
		break;
	    }

	    if (n == 0) {
		if (small.length() == big.length()) {
		    winner = "draw";
		} else {
		    winner = "big";
		}
		break;
	    }

	    idx++;
	}
	return winner;
    }
}
