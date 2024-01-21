package Q16397_탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private int N, T, G, ans;

	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.input();
		m.solve();
		m.output();
	}

	private void output() {
		System.out.println(ans == -1 ? "ANG" : ans);
	}

	private void solve() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{N, 0});
		boolean visited[] = new boolean[100000];
		visited[N] = true;
		ans = -1;
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[1] > T) {
				return;
			}

			if (curr[0] == G) {
				ans = curr[1];
				return;
			}


			// A
			int next = curr[0] + 1;
			if (next > 0 && next <= 99999 && !visited[next]) {
				visited[next] = true;
				q.add(new int[]{next, curr[1] + 1});
			}


			// B
			next = curr[0] * 2;
			if (next > 0 && next <= 99999) {
				int size = String.valueOf(next).length();
				int div = (int) (Math.pow(10, size - 1));
				int ret = (next / div - 1) * div + (next % div);

				if (ret > 0 && ret <= 99999 && !visited[ret]) {
					visited[ret] = true;
					q.add(new int[]{ret, curr[1] + 1});
				}
			}
		}
	}

	private void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();
		G = sc.nextInt();
	}
}
