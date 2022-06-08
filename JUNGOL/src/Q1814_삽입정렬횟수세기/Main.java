package Q1814_삽입정렬횟수세기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = 0;
		for (int i = 1; i < N; i++) {
			int key = arr[i];
			int j;
			int m = 0;
			for (j = i - 1; j >= 0 && arr[j] > key; j--) {
				arr[j + 1] = arr[j];
				m++;

			}
			ans += m;
			arr[j + 1] = key;
//			System.out.println(Arrays.toString(arr));
		}
		System.out.println(ans);
	}
}
