package Q1071_약수와배수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N; i++) 
			arr[i] = sc.nextInt();
		
		int n = sc.nextInt();
		int sum = 0; // 약수의 합
		int sum2 = 0; // 배수의 합
		for(int i=0;i<N; i++) {
			if(n % arr[i] == 0 && arr[i] <= n ) 
				sum += arr[i];
			if(arr[i] % n == 0 && n<=arr[i]) {
				sum2 += arr[i];
			}
		}		
		System.out.println(sum);
		System.out.println(sum2);
	}
}
