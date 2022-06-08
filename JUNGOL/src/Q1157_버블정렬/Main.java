package Q1157_버블정렬;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			for(int j = 0; j < N; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}
}
