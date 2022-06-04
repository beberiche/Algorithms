package Q1329_별삼각형3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N%2 == 0 || N<1 || N > 100) {
			System.out.println("INPUT ERROR!");
		} else {
			int space= 0;
			for(int i=0;i<=N/2;i++) {
				for(int s=0; s<space;s++) {
					System.out.print(" ");
				}
				for(int j=0;j<i*2+1; j++) {
					System.out.print("*");
				}
				space++;
				System.out.println();
			}
			space-=2;
			int idx = N;
			for(int i=N/2+1; i<N; i++) {
				idx-=2;
				for(int s=0; s<space;s++) {
					System.out.print(" ");
				} 
				for(int j=0; j<idx;j++) {
					System.out.print("*");
				}
				space--;
				System.out.println();
			}
		}
	}
}
