package Q1592_영식이와_친구들;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();

	int first = 1;
	int ans = 0;
	int throwCnt = sc.nextInt() - 1;
	int L = sc.nextInt();
	while (throwCnt > 0) {
	    if ((first += L) % N == 1) {
		throwCnt--;
	    }
	    ans++;
	}
	System.out.println(ans);
    }
}
