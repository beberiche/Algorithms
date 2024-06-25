package Q1011_Fly_me_to_the_Alpha_Centauri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (--T >= 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(stk.nextToken());
			int Y = Integer.parseInt(stk.nextToken());

			int diff = Y - X;
			int n = (int) Math.sqrt(diff);
			if (n * n == diff) {
				sb.append(n * 2 - 1);
			} else if (diff <= n * n + n) {
				sb.append(n * 2);
			} else if (n * n < diff) {
				sb.append(n * 2 + 1);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
