package Q2470_두용액;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int st = 0;
		int ed = 1;
		int[] ans = { 0, 0, Integer.MAX_VALUE };
		while (ed < arr.length && st<arr.length) {
			int val = arr[st] + arr[ed];
			if (ans[2] > Math.abs(val)) {
				ans[0] = st;
				ans[1] = ed;
				ans[2] = Math.abs(val);
			}
			if (val == 0)
				break;
			else if (val > 0)
				st++;
			else
				ed++;

		}

		System.out.println(ans[0] < ans[1] ? arr[ans[0]] + " " + arr[ans[1]] : arr[ans[1]] + " " + arr[ans[0]]);
	}
}