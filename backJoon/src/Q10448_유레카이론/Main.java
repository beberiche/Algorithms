package Q10448_유레카이론;

import java.util.Scanner;

public class Main {
	static int idx;
	static int[] tri;
	static int[] arr = new int[3];
	static boolean flag = false;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		tri = new int[1001];
		for (int i = 1; i < 1001; i++) {
			tri[i] = i * (i + 1) / 2;
			if (tri[i] > 1000) {
				idx = i - 1;
				break;
			}
		}
		for (int t = 0; t < N; t++) {
			ans = 0;
			recur(0, sc.nextInt());
			System.out.println(ans);
		}
	}

	public static void recur(int cnt, int goal) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += tri[arr[i]];
			}
			if (sum == goal)
				ans = 1;
		} else {
			for (int i = 1; i <= idx; i++) {
				arr[cnt] = i;
				recur(cnt + 1, goal);
			}
		}

	}
}
