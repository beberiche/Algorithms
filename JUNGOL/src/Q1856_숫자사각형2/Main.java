package Q1856_숫자사각형2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int num = 1;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			if(i%2==0) {
				for(int j=0; j<m;j++) {
					sb.append(num++).append(" ");
				}
				sb.append("\n");
			} else {
				for(int j=m-1; j>=0; j--) {
					sb.append(num + j).append(" ");
				}
				sb.append("\n");
				num += m;
			}
		}
		System.out.println(sb.toString());
	}
}
