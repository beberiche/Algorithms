package Q2604_그릇;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();

		int sum = 10;
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1] != arr[i]) {
				sum+=10;
			} else {
				sum+=5;
			}
		}
		System.out.println(sum);
	}
}
