package Q1523_별삼각형1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		if (n < 1 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
		} else if (m == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (m == 2) {
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			int space = n-1;
			int star = 1;
			
			for(int i=0; i<n; i++) {
				for(int s = 0; s<space; s++) {
					System.out.print(" ");
				} 
				for(int s = 0; s<star; s++) {
					System.out.print("*");
				}
				for(int s = 0; s<space; s++) {
					System.out.print(" ");
				} 
				System.out.println();
				space--;
				star+=2;
			}
		}
	}
}
