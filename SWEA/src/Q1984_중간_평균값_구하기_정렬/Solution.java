package Q1984_중간_평균값_구하기_정렬;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int TC = sc.nextInt();

	for (int i = 1; i <= TC; i++) {
	    // 배열 설정
	    int[] arr = new int[10];
	    for (int j = 0; j < 10; j++) {
		arr[j] = sc.nextInt();
	    }

	    // 정렬
	    Arrays.sort(arr);

	    int sum = 0;
	    for (int j = 1; j < 9; j++) {
		sum += arr[j];
	    }

	    System.out.printf("#%d %d\n", i, Math.round(sum / 8.0));
	}
    }
}
