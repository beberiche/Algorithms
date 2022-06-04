package Q2437_저울;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] map = new int[N];

		for (int i = 0; i < N; i++) {
			map[i] = sc.nextInt();
		}

		Arrays.sort(map);
		// 정렬한 후 맵이 가장 작은데
		// 가장 작은 정수인 1보다 커버리면
		// 무게를 잴 수 없는 최소 정수는 1이 된다.
		if (map[0] > 1) {
			System.out.println(1);
			return;
		}

		int sum = 1;
		for (int i = 1; i < N; i++) {
			if (map[i] > sum + 1) {
				break;
			}
			sum += map[i];
		}
		System.out.println(sum + 1);

	}
}
