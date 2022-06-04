package Q13116_30번;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (--T >= 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			List<Integer> list = new ArrayList<>();

			// 무조건 작은게 n1이 되도록 한다.
			if (n1 > n2) {
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}

			// n1을 기준으로 부모노드의 값을 모두 리스트에 넣는다.
			list.add(n1);
			while (n1 != 1) {
				list.add(n1 /= 2);
			}

			// n2의 부모를 찾으며, 만약 n1과 동일한 부모가 있다면 반복문을 종료한다.
			int ans = 0;
			outer: while (n2 != 0) {
				for (int i = 0; i < list.size(); i++) {
					if (n2 == list.get(i)) {
						ans = list.get(i);
						break outer;
					}
				}
				n2 /= 2;
			}

			System.out.println(ans * 10);

		}
	}
}
