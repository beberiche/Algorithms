package Q1169_주사위던지기1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		if (M == 1) {
			recur1(1, 6, N, "");
		} else if (M == 2) {
			recur2(1, 6, N, "");
		} else if (M == 3) {
			boolean[] visited = new boolean[7];
			recur3(1, 6, N, "", visited);
		}
	}

	private static void recur1(int idx, int dice, int cnt, String ans) {
		// TODO Auto-generated method stub
		if (idx == cnt + 1) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= dice; i++) {
			recur1(idx + 1, dice, cnt, ans + i + " ");
		}
	}

	private static void recur2(int idx, int dice, int cnt, String ans) {
		// TODO Auto-generated method stub
		if (idx == cnt + 1) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= dice; i++) {
			if (ans.length() == 0 || ans.charAt(ans.length() - 2) - '0' <= i) {
				recur2(idx + 1, dice, cnt, ans + i + " ");
			}
		}
	}

	private static void recur3(int idx, int dice, int cnt, String ans, boolean[] visited) {
		// TODO Auto-generated method stub
		if (idx == cnt + 1) {
			System.out.println(ans);
			return;
		}
		for (int i = 1; i <= dice; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			recur3(idx + 1, dice, cnt, ans + i + " ", visited);
			visited[i] = false;
		}
	}
}
