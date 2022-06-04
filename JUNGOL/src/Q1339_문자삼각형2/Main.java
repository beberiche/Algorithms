package Q1339_문자삼각형2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N <1 || N>100 || N % 2 == 0) {
			System.out.println("INPUT ERROR");
			return;
		} else {
			int idx = 0;
			int mid = N/2;
			char[][] arr = new char[N][N];
			char ch = 'A';
			for(int i=mid; i>=0; i--) {
				for(int j=mid-idx; j<=mid+idx; j++) {
					if(ch-'0' == 43) {
						ch = 'A';
					}
					arr[j][i] = ch++;
				}
				idx++;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					if(arr[i][j] > 0) {
						System.out.print(arr[i][j] + " ");						
					} else {
						System.out.print("   ");
					}
				}
				System.out.println();
			}
		}
	}
}
