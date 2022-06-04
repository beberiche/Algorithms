package Q10250_기본_수학;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();

	for (int i = 0; i < T; i++) {
	    int H = sc.nextInt();
	    int W = sc.nextInt();
	    int N = sc.nextInt();
	    int cnt = 0;
	    for (int j = 0; j < W; j++) {
		for (int k = H - 1; k >= 0; k--) {
		    cnt++;
		    if (cnt == N) {
			System.out.println(Math.abs(H - k) + "0" + (j + 1));
		    }
		}
	    }
	}
    }
}
