package Q1307_문자사각형1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[][] arr= new char[N][N];
		
		
		char ch = 'A';
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>=0; j--) {
				if(ch-'0' == 43) {
					ch = 'A';
				}
				arr[j][i] = ch++;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0;j<N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
