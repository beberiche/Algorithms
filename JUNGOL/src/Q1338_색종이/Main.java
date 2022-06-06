package Q1338_색종이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[101][101];
		int N = sc.nextInt();

		while (--N >= 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length; j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
