package Q2814_이진수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		char[] arr = new Scanner(System.in).nextLine().toCharArray();

		int bin = 1;
		int sum = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == '1') 
				sum += (arr[i]-'0') * bin;
			
			bin *= 2;
		}
		System.out.println(sum);
	}
}
