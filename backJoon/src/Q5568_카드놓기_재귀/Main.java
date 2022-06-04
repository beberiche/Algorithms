package Q5568_카드놓기_재귀;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int K;
	static int N;
	static int[] arr;
	static int idx;
	static List<String> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		ans = new ArrayList<>();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		combCard(K, "");
		System.out.println(new HashSet<String>(ans).size());

	}

	static boolean[] visited = new boolean[11];

	public static void combCard(int cnt, String str) {
		if (cnt == 0) {
			ans.add(str);
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combCard(cnt - 1, str + arr[i]);
				visited[i] = false;
			}

		}
	}
}
