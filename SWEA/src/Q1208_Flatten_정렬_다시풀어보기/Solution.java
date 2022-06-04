package Q1208_Flatten_정렬_다시풀어보기;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);

	for (int tc = 1; tc <= 10; tc++) {
	    int dump = sc.nextInt();
	    int[] arr = new int[100];

	    // 배열 생성
	    for (int i = 0; i < 100; i++) {
		arr[i] = sc.nextInt();
	    }
	    ;

	    // 버블 정렬
	    arr = sorting(arr);

	    // 덤프
	    int cnt = 0;
	    for (int i = 0; i < dump; i++) {
		if (cnt == dump) {
		    break;
		}
		arr[99]--;
		arr[0]++;
		if (arr[99] < arr[98] || arr[0] > arr[1]) {
		    arr = sorting(arr);
		}
	    }

	    System.out.printf("#%d %d\n", tc, arr[99] - arr[0]);

	}
    }

    public static int[] sorting(int[] arr) {
	for (int i = 0; i < 100; i++) {
	    for (int j = i + 1; j < 100; j++) {
		if (arr[i] > arr[j]) {
		    int temp = arr[i];
		    arr[i] = arr[j];
		    arr[j] = temp;
		}
	    }
	}
	return arr;
    }
}