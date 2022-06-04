package Q1676_팩토리얼;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt5 = 0;
		
		for(int i=1; i<=n; i++) {
			int target = i;
			while((target % 5 == 0)) {
				cnt5++;
				target /= 5; 
			}
		}
		
		System.out.println(cnt5);
	}
}
