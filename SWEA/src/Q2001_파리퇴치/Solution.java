package Q2001_파리퇴치;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input2001.txt"));
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();

	for (int TC = 1; TC <= T; TC++) {

	    int N = sc.nextInt(); // 배열 길이
	    int M = sc.nextInt(); // 파리채 영역

	    // 배열 만들기
	    int[][] map = new int[N][N];
	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
		    map[i][j] = sc.nextInt();
		}
	    }

	    int max = 0;
	    for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
		    int sum = 0;
		    // 해당 지점부터 아래로 1칸
		    // 해당 지점부터 오른쪽으로 1칸 전진하며
		    // 잡은 파리 수 누적하기.
		    outer: for (int k = 0; k < M; k++) {
			for (int l = 0; l < M; l++) {
			    if (i + k >= N || j + l >= N) {
				break outer;
			    }
			    sum += map[i + k][j + l];
			}
		    }
		    // max 값과 비교
		    // sum이 더 크면 max = sum
		    // 아니면 max = max
		    max = max <= sum ? sum : max;
		}
	    }
	    System.out.printf("#%d %d\n", TC, max);
	}

    }
}
