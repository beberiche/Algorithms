package Q1495_대각선지그재그;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][N];

		int r = 1;
		int c = 0;
		int ep = 2;
		int num = 1;
		arr[0][0] = num++;
		while (true) {
			if (ep % 2 == 0) {
				for (int i = 0; i < ep; i++) {
					arr[r--][c++] = num++;
				}
				r++;
			} else {
				for (int i = 0; i < ep; i++) {
					arr[r++][c--] = num++;
				}
				c++;
			}
			if (ep == N) {
				if (N % 2 == 1) {
					r--;
					c++;
				} else {
					r++;
					c--;
				}
				ep--;
				break;
			}
			ep++;
		}

		while (true) {
			if (ep % 2 == 0) {
				for (int i = 0; i < ep; i++) {
					arr[r--][c++] = num++;
				}
				r += 2;
				c--;
			} else {
				for (int i = 0; i < ep; i++) {
					arr[r++][c--] = num++;
				}
				c += 2;
				r--;
			}
			if (ep == 0) {
				break;
			}
			ep--;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
