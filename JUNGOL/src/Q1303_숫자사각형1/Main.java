package Q1303_숫자사각형1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int num = 1;
		
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0;j<m; j++) {
				sb.append(num++).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
