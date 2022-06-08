package Q1158_삽입정렬;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=1; i<N; i++) {
			int key = arr[i];
			
			int j;
			for(j=i-1; j>=0 && arr[j] > key; j--) {
				arr[j+1] = arr[j];
			}
			
			arr[j+1] = key;
			for(int k=0; k<N; k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
		}
		
	}
}
