package Q2981_검문;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int[] newArr = new int[N - 1];

		int idx = 0;
		for (int i = 0; i < N - 1; i++) {
			newArr[i] = arr[i] - arr[i + 1];
		}
		List<Integer> ans = new ArrayList<>();
		commonFactor(newArr, ans);
		for (int n : ans) {
			System.out.print(n + " ");
		}
	}

	public static void commonFactor(int[] arr, List<Integer> ans) {
		outer: for (int i = 2; i <= arr[0]; i++) {
			if (arr[0] % i == 0) {
				for (int j = 1; j < arr.length; j++) {
					if (arr[0] % i != arr[j] % i)
						continue outer;
				}
				ans.add(i);
			}
		}
	}
}
