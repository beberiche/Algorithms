package Q1338_문자삼각형1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		char ch = 'A';
		char [][] arr= new char[N][N];
		
		for(int i=0;i<N; i++) {
			for(int j=i, k=N-1; j<N; j++, k-- ) {
				if(ch-'0' == 43) {
					ch = 'A';
				}
				arr[j][k] = ch++;
			}
		}	
		
		for(int i=0;i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] > 0) {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
