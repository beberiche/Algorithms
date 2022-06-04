package Q2071_평균값_구하기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int N = sc.nextInt();

	for (int i = 1; i <= N; i++) {
	    int sum = 0;
	    int[] arr = new int[10];
	    for (int j = 0; j < arr.length; j++) {
		arr[j] = sc.nextInt();
		sum += arr[j];
	    }

//	    System.out.printf("#%d %d\n", i, Math.round(sum / 10.0));
	    System.out.printf("#%d %d\n", i, (int) (sum / 10.0 + 0.5));
	}
    }
}
