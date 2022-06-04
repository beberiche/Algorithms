package Q11726_2xN타일링;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(1);

		System.out.println(solve(list, N));
	}

	public static Integer solve(List<Integer> list, int n) {
		if (n < list.size()) {
			return list.get(n);
		} else {
			int temp = solve(list, n - 1) + solve(list, n - 2);
			list.add(temp);
			return temp % 10007;
		}
	}
}
