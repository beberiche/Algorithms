package Q5215_햄버거다이어트;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int[][] arr;
    static int calorieLimit;
    static int maxScore;
    static int N;

    public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("./data/input5215.txt"));
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	for (int TC = 1; TC <= T; TC++) {
	    maxScore = 0;
	    N = sc.nextInt(); // 필요한 배열 양

	    calorieLimit = sc.nextInt(); // 칼로리 제한

	    arr = new int[N][2]; // [[맛에대한 점수, 칼로리],[맛에대한 점수, 칼로리]...]

	    for (int i = 0; i < N; i++) {
		arr[i][0] = sc.nextInt(); // 맛점수
		arr[i][1] = sc.nextInt(); // 칼로리
	    }

	    score(0, 0, 0);
	    System.out.printf("#%d %d\n", TC, maxScore);
	}

    }

    private static void score(int n, int sumCalorie, int sumScore) {
	if (sumCalorie > calorieLimit) {
	    return;
	} else {
	    if (n == N) {
		maxScore = Math.max(maxScore, sumScore);
		return;
	    }
	}

	score(n + 1, sumCalorie, sumScore);
	score(n + 1, sumCalorie + arr[n][1], sumScore + arr[n][0]);
    }
}
