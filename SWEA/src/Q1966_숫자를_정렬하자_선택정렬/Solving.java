package Q1966_숫자를_정렬하자_선택정렬;


import java.util.Scanner;

public class Solving {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			int N2 = sc.nextInt();
			int[] arr = new int[N2];
			
			for(int j=0; j<N2; j++) {
				arr[j] = sc.nextInt();
			}
			
			for(int j=0; j<N2; j++) {
				int minIdx = j;
				for(int k=j+1; k<N2; k++) {
					if(arr[minIdx] > arr[k]) {
						minIdx = k;
					}
				}
				int temp = arr[j];
				arr[j] = arr[minIdx];
				arr[minIdx] = temp;
			}
			
			StringBuffer sb = new StringBuffer();
			for(int j=0; j<N2; j++) {
				sb.append(arr[j] + " ");
			}
			
			System.out.printf("#%d %s",i,sb);
			System.out.println();
		}
	}
}
