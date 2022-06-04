package Q1692_곱셈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		char[] arr = String.valueOf(num2).toCharArray();
		
		for(int i=arr.length-1;i>=0; i--) 
			System.out.println(num1 * (arr[i] - '0'));
		
		System.out.println(num1 * num2);
	}
}
