package Q1719_별삼각형2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n % 2== 0 || n < 1 || n > 100 || m < 1 || m > 4) {
			System.out.println("INPUT ERROR!");
		} else if(m==1) {
			for(int i=0; i<=n/2;i++) {
				for(int j=0; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			for(int i=n/2+1; i<n; i++) {
				for(int j=0; j<n-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if(m==2) {
			for(int i=0; i<=n/2; i++) {
				for(int j=n/2; j>i; j--) {
					System.out.print(" ");
				}
				for(int j=0;j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			for(int i=n/2+1; i<n; i++) {
				for(int j=i; j>n/2; j--) {
					System.out.print(" ");
				}
				for(int j=n-1; j>=i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			
		} else if(m==3) {
			int space = 0;
			for(int i=n; i>=1; i-=2) {
				for(int s=0; s<space; s++) {
					System.out.print(" ");
				}
				for(int j=0; j<i; j++) {
					System.out.print("*");
				}
				for(int s=0; s<space; s++) {
					System.out.print(" ");
				}
				space+=1;
				System.out.println();
			}
			space-=2;
			for(int i=3; i<=n; i+=2) {
				for(int s=0; s<space; s++) {
					System.out.print(" ");
				}
				for(int j=0; j<i; j++) {
					System.out.print("*");
				}
				for(int s=0; s<space; s++) {
					System.out.print(" ");
				}
				space-=1;
				System.out.println();
			}
		} else {
			int space=0;
			for(int i=n/2 + 1; i>=1; i--) {
				for(int s = 0; s<space; s++) {
					System.out.print(" ");
				}
				for(int j=0;j<i;j++) {
					System.out.print("*");
				}
				space++;
				System.out.println();
			}
			space-=1;
			for(int i=2; i<=n/2+1; i++) {
				for(int s=0; s<space; s++) {
					System.out.print(" ");
				}
				for(int j=0;j<i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
