package Q1707_달팽이사각형;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][N];
		
		int num = 1;
		for(int i=0; i<N; i++) {
			arr[0][i] = num++;
		}
		
		int vect = 1;
		int ep = N-1;
		int r = 0;
		int c = N-1;
		while(ep>0) {
			if(vect==1) {
				for(int a=0;a<ep; a++) { 
					arr[++r][c] = num++;
				}
				vect=2;
			} else if(vect==2) {
				for(int a=0; a<ep; a++) {
					arr[r][--c] = num++;
				}
				vect=3;
				ep--;
			} else if(vect==3) {
				for(int a=0; a<ep; a++) {
					arr[--r][c] = num++;
				}
				vect=0;
			} else {
				for(int a=0; a<ep; a++) {
					arr[r][++c] = num++;
				}
				vect=1;
				ep--;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
