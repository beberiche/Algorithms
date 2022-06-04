package Q1534_10진수를2_8_16_진수로;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		
		if(B==2) {
			System.out.println(Integer.toBinaryString(N));
		} else if(B==8) {
			System.out.println(Integer.toOctalString(N));
		} else {
			System.out.println(Integer.toHexString(N).toUpperCase());
		}
	}
}
