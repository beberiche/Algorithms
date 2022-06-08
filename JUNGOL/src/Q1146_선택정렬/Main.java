package Q1146_선택정렬;

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

		for (int i = 0; i < N - 1; i++) {
			int minIdx = i;

			for (int j = i + 1; j < N; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
			System.out.println(Arrays.toString(arr).replace("[", "").replace("]", "")
					.replace(" ", "").replace(",", " "));

		}
	}
}
