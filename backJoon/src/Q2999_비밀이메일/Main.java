package Q2999_비밀이메일;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	String text = sc.next();

	// 아직도 행렬이 헷갈린다....
	int r = 1;
	int c = 0;
	for (int i = 1; i <= text.length(); i++) {
	    if (text.length() % i == 0 && r >= c) {
		int temp1 = i;
		int temp2 = text.length() / i;
		if (temp1 > temp2) {
		    break;
		} else {
		    c = temp1;
		    r = temp2;
		}
	    }
	}

	char[][] template = new char[r][c];

	int cnt = 0;
	for (int i = 0; i < r; i++) {
	    for (int j = 0; j < c; j++) {
		template[i][j] = text.charAt(cnt++);
	    }
	}

	// 출력
	for (int j = 0; j < c; j++) {
	    for (int i = 0; i < r; i++) {
		System.out.print(template[i][j]);
	    }
	}

    }
}
