package Q10973_이전순열;

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

		prevPerm();
	}

	static void prevPerm() {
		boolean check = false;
		outer: for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				for (int j = arr.length - 1; j >= i; j--) {
					if (arr[i - 1] > arr[j]) {
						swap(i - 1, j);
						int n = arr.length - 1;
						while (i < n) {
							swap(i, n);
							i++;
							n--;
						}
						check = true;
						break outer;
					}
				}
			}
		}
		if (check) {
			for (int a : arr) {
				System.out.print(a + " ");
			}
		} else {
			System.out.print(-1);
		}
	}

	static void swap(int n1, int n2) {
		int temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}
}
