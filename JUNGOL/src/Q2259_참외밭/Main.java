package Q2259_참외밭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			arr[i] = sc.nextInt();
		}

		int width = 0;
		int height = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				width = Math.max(arr[i], width);
			} else {
				height = Math.max(arr[i], height);
			}
		}

		int width2 = 0;
		int height2 = 0;
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				if (height == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
					width2 = arr[i];
				}
			} else {
				if (width == arr[(i + 5) % 6] + arr[(i + 1) % 6]) {
					height2 = arr[i];
				}
			}
		}

		System.out.println((width * height - width2 * height2) * N);
	}

}
