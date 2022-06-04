package Q2046_숫자사각형4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		if(m==1) {
			int cnt = 1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = cnt;
				}
				cnt++;
			}			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		} else if(m==2) {
			int cnt = 1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = cnt++;
				}
				cnt = 1;
			}
			for(int i=0;i<n;i++) {
				if(i%2 == 0) {
					for(int j=0;j<n;j++) {
						System.out.print(arr[i][j] + " ");
					}		
				} else {
					for(int j=n-1; j>=0;j--) {
						System.out.print(arr[i][j] + " ");	
					}
				}
				System.out.println();
			}
		} else {
			int cnt = 1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = cnt + j*(i+1);
				}
				cnt++;
			}
			for(int i=0;i<n; i++) {
				for(int j=0;j<n; j++) {
					System.out.print(arr[j][i] + " ");
				}
				System.out.println();
			}
		}
		
	}
}
