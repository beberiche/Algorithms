package Q2292_벌집;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int N = sc.nextInt();

	int st = 1;
	int floor = 1;
	int mul = 6;
	while (N > st) {
	    st += mul;
	    mul += 6;
	    floor++;
	}
	System.out.println(floor);
    }
}
