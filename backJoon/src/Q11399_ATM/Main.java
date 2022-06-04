package Q11399_ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int N = sc.nextInt();

	int[] arr = new int[N];

	for (int i = 0; i < N; i++) {
	    arr[i] = sc.nextInt();
	}

	// 선택정렬
	for (int i = 0; i < N; i++) {
	    int minIdx = i;
	    for (int j = i + 1; j < N; j++) {
		if (arr[minIdx] > arr[j])
		    minIdx = j;
	    }
	    int tmp = arr[i];
	    arr[i] = arr[minIdx];
	    arr[minIdx] = tmp;
	}

	// 누적합 구하기
	int sum = 0;
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j <= i; j++) {
		sum += arr[j];
	    }
	}
	System.out.println(sum);

    }
}
