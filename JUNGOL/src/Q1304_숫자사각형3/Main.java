package Q1304_숫자사각형3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr= new int[N][N];
		
		int cnt = 1;
		for(int i=0;i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = cnt++;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0;j<N; j++) {
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();
		}
	}
}
