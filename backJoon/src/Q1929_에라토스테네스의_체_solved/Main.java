package Q1929_에라토스테네스의_체_solved;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean [] arr = new boolean[N+1];
		arr[0] = arr[1] = true;
		
		
		for(int i=2; i*i<=N; i++) {
			if(!arr[i]) {
				for(int j=i*i; j<=N; j+=i) {
					arr[j] = true;
				}
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(!arr[i]) { 
				System.out.println(i);
			}
		}
	}
}
