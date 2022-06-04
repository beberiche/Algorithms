package Q3052_나머지;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	Set<Integer> remainder = new HashSet<>();

	// set에 집어넣기 - 중복된 값은 생성되지 않는다.
	for (int i = 0; i < 10; i++) {
	    int n = sc.nextInt();
	    remainder.add(n % 42);
	}

	System.out.println(remainder.size());

    }
}
