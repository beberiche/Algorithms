package Q1430_숫자의개수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int[] cnt = new int[10];
		
		char[] numArr = String.valueOf(a*b*c).toCharArray();
		
		for(int i=0;i<numArr.length;i++) 
			cnt[numArr[i]-'0']++;
		
		for(int i=0;i<10; i++) {
			System.out.println(cnt[i]);
		}
	}
}
