package Q1002_최대공약수_최소공배수;

import java.util.Scanner;

public class Main {
	static int gcd;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		GCD(arr, 1);

		int idx = 1;
		int lcm = 0;
		while (true) {
			int temp = gcd * idx;

			boolean check = true;
			for (int i = 0; i < N; i++) {
				if (temp % arr[i] != 0) {
					check = false;
					break;
				}
			}
			
			if(check) {
				lcm = temp; 
				break;
			}
			idx++;
			
		}
		System.out.print(gcd + " " + lcm);
	}

	private static void GCD(int[] arr, int cnt) {
		boolean check = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < cnt) {
				return;
			}
			if (arr[i] % cnt != 0) {
				check = false;
				break;
			}
		}

		if (check) {
			gcd = cnt;
		}
		GCD(arr, cnt + 1);
	}

}
