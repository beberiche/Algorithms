package Q1026_보물_정렬;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();

	int[] arr1 = new int[N];
	int[] arr2 = new int[N];
	for (int i = 0; i < N; i++) {
	    arr1[i] = sc.nextInt();
	}
	for (int i = 0; i < N; i++) {
	    arr2[i] = sc.nextInt();
	}

	for (int i = 0; i < N; i++) {
	    int minIdx = i;
	    for (int j = i + 1; j < N; j++) {
		if (arr1[j] < arr1[minIdx]) {
		    minIdx = j;
		}
	    }
	    int tmp = arr1[i];
	    arr1[i] = arr1[minIdx];
	    arr1[minIdx] = tmp;
	}

	int sum = 0;
	int cnt = 0;
	int[] temp = new int[101];
	for (int i = 100; i >= 1; i--) {
	    temp[i] = i;
	    for (int j = 0; j < arr2.length; j++) {
		if (arr2[j] == temp[i]) {
		    sum += arr1[cnt] * temp[i];
		    cnt++;
		}
	    }
	}
	System.out.println(sum);
    }
}
