package Q1206_View_완전탐색_다시풀어보기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	for (int tc = 1; tc <= 10; tc++) {
	    int N = sc.nextInt();
	    int[] view = new int[N];

	    // 배열 넣기
	    for (int i = 0; i < N; i++) {
		view[i] = sc.nextInt();
	    }

	    // height 구하기
	    int total = 0;
	    for (int i = 2; i < N - 2; i++) {
		// 탐색 조건 설정
		boolean check = true;
		// 높이 값 설정
		int height = 9999;
		// 탐색 배열 설정
		int[] dx = { -2, -1, 1, 2 };

		for (int j = 0; j < 4; j++) {
		    if (view[i] < view[i + dx[j]]) {
			check = false;
			break;
		    }

		    if (height > (view[i] - view[i + dx[j]])) {
			height = (view[i] - view[i + dx[j]]);
		    }
		}

		if (check) {
		    total += height;
		}
	    }
	    System.out.printf("#%d %d\n", tc, total);
	}
    }
}
