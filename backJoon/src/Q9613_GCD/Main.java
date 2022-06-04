package Q9613_GCD;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int tc = sc.nextInt();
	for (int i = 0; i < tc; i++) {
	    int n = sc.nextInt();
	    int[] arr = new int[n];
	    for (int j = 0; j < n; j++) {
		arr[j] = sc.nextInt();
	    }

	    long sum = 0;
	    for (int j = 0; j < n; j++) {
		for (int k = j + 1; k < n; k++) {
		    sum += GCD(arr[j], arr[k]);
		}
	    }
	    System.out.println(sum);
	}
    }

    public static int GCD(int a, int b) {
	return b == 0 ? a : GCD(b, a % b);
    }

}