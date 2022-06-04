package Q1193_기본_수학_solved;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 0;
		int z = 0;
		
		while(true) {
			z++;
			cnt += z;
			if(cnt >= n) {
				if(z%2==0) {
					System.out.println((n-cnt+z) + "/" + (cnt-n+1));
				} else {
					System.out.println((cnt-n+1) + "/" + (n-cnt+z));
				}
				break;
			}
		}
	} 
}
