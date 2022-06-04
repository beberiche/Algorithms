package Q1860_진기의최고급붕어빵;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
//    public static void main(String[] args) throws Exception {
//	System.setIn(new FileInputStream("./data/input1860.txt"));
//	Scanner sc = new Scanner(System.in);
//
//	int T = sc.nextInt();
//	for (int TC = 1; TC <= T; TC++) {
//	    int N = sc.nextInt(); // 사람수
//	    int M = sc.nextInt(); // 시간
//	    int K = sc.nextInt(); // 붕어빵 개수
//
//	    String ans = "Possible";
//
//	    int[] sell = new int[11112];
//
//	    for (int i = 0; i < N; i++) {
//		sell[sc.nextInt()]++;
//	    }
//
//	    int bread = 0; // 실제 빵의 갯수
//
//	    // 실제로 매초마다 생각을 해보자...
//	    for (int i = 0; i < sell.length; i++) {
//		// 빵을 일단 만들자.
//		if (i > 0 && i % M == 0) {
//		    bread += K;
//		}
//
//		bread -= sell[i];
//		if (bread < 0) {
//		    ans = "Impossible";
//		}
//	    }
//
//	    System.out.printf("#%d %s\n", TC, ans);
//	}
//    }

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input1860.txt"));
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	for (int TC = 1; TC <= T; TC++) {
	    int N = sc.nextInt(); // 손님수
	    int M = sc.nextInt(); // 걸리는 시간
	    int K = sc.nextInt(); // 만드는 붕어빵

	    String ans = "Possible";

	    int[] cnt = new int[11112];

	    for (int i = 0; i < N; i++) {
		cnt[sc.nextInt()]++;
	    }

	    int bread = 0;
	    for (int i = 0; i < cnt.length; i++) {
		if (i > 0 && i % M == 0) {
		    bread += K;
		}

		bread -= cnt[i];

		if (bread < 0) {
		    ans = "Impossible";
		    break;
		}
	    }

	    System.out.printf("#%d %s\n", TC, ans);
	}
    }
}
