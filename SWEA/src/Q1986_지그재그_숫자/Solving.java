package Q1986_지그재그_숫자;

import java.util.Scanner;

public class Solving {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();

	for (int i = 1; i <= N; i++) {
	    int N2 = sc.nextInt();
	    int[] arr = new int[N2];

	    int cnt = 1;
	    for (int j = 0; j < N2; j++) {
		arr[j] = cnt++;
	    }

	    int sum = 1;
	    for (int j = 1; j < N2; j++) {
		int val = j % 2 == 0 ? arr[j] : -arr[j];
		sum += val;
	    }
	    System.out.printf("#%d %d\n", i, sum);
	}
    }
}
