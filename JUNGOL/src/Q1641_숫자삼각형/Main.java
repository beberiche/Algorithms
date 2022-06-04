package Q1641_숫자삼각형;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		if (n % 2 == 0 || n < 1 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
		} else if (m == 1) {
			int[][] arr = new int[n][n];
			int cnt = 1;
			int total = 1;
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < total; j++) {
						arr[i][j] = cnt++;
					}
				} else {
					for (int j = total-1; j >= 0; j--) {
						arr[i][j] = cnt++;
					}
				}
				total++;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0) {
						System.out.print(arr[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else if(m==2) {
			int space = 0;
			int num = 0;
			for(int i=0; i<2*n-1; i++) {
				for(int s=0; s<space; s++) {
					System.out.print("  ");
				}
				for(int j=0;j<(2*n-1) - (space*2); j++) {
					System.out.print(num + " ");
				}
				for(int s=0; s<space; s++) {
					System.out.print("  ");
				}
				System.out.println();
				space++;
				num++;
			}
		} else {
			for(int i=1; i<=n/2+1; i++) {
				for(int j=1; j<=i; j++) {
					System.out.print(j + " ");					
				}
				System.out.println();
			}
			for(int i=n/2+2, num=n/2; i<=n; i++, num--) {
				for(int j=1; j<=num; j++) {
					System.out.print(j+ " ");
				}
				System.out.println();
			}
		}

	}
}
