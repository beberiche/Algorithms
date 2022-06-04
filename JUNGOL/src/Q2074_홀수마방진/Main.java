package Q2074_홀수마방진;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N + 1][N + 1];

		int i = 1;
		int j = N / 2 +1;
		int num = 1;
		arr[i][j] = num++;
		int cnt=0;
		while (++cnt<N*N) {
			if (cnt % N == 0) {
				arr[++i][j] = num++;
			} else if (j - 1 <= 0) {
				arr[--i][N] = num++;
				j=N;
			} else if (i - 1 <= 0) {
				arr[N][--j] = num++;
				i=N;
			} else {
				arr[--i][--j] = num++;
			}
		}
		for(int r=1; r<=N;r++) {
			for(int c=1; c<=N; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}
