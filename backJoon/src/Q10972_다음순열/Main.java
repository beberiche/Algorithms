package Q10972_다음순열;

import java.util.Scanner;

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		nextPerm();
	}

	private static void nextPerm() {
		boolean check = true;
		outer: for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i]) {
				for (int j = arr.length - 1; j >= i; j--) {
					if (arr[i - 1] < arr[j]) {
						swap(j, i - 1);
						int n = arr.length - 1;
						while (i < n) {
							swap(i, n);
							i++;
							n--;
						}
						check = false;
						break outer;
					}
				}
			}
		}
		if (check) {
			System.out.println(-1);
		} else {
			for (int a : arr) {
				System.out.print(a + " ");
			}
		}

	}

	private static void swap(int n1, int n2) {
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}
}