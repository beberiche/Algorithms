package Q2809_약수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(N);
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0) {
				list.add(i);
				if(i*i != N)
					list.add(N/i);
			}
		}
		
		Collections.sort(list);
		for(int n : list) 
			System.out.print(n + " ");
	}
}
