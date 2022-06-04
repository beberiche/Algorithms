package Q2071_파스칼삼각형;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0, j = 0; i < n; i++, j++) {
			arr[i][0] = 1;
			arr[i][j] = 1;
		}

		for (int i = 2; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
		}

		if (m == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > 0) {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else if(m==2) {
			for(int i=n-1; i>=0; i--) {
				for(int j=n-1; j>=0; j--) {
					if(arr[i][j] > 0) {
						System.out.print(arr[i][j] + " ");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		} else if(m==3) {
			for(int i=n-1; i>=0; i--) {
				for(int j=n-1; j>=i; j--) {
					if(arr[j][i] > 0) {
						System.out.print(arr[j][i] + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
