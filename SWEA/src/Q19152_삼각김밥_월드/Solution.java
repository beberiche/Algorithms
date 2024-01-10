package Q19152_삼각김밥_월드;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// init
		int[][] a = new int[10001][2];
		int r = 0;
		int num = 1;
		outer:
		while (true) {
			for (int c = 0; c <= r; ++c) {
				a[num][0] = r;
				a[num++][1] = c;
				if (num > 10000) break outer;
			}
			++r;
		}

		// solve
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int s, e;
		for (int t = 1; t <= T; ++t) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			s = Integer.parseInt(stk.nextToken());
			e = Integer.parseInt(stk.nextToken());
			if (s > e) {
				int tmp = s;
				s = e;
				e = tmp;
			}
			int[] curr = new int[]{a[s][0], a[s][1], 0};
			while (curr[1] < a[e][1] && curr[0] < a[e][0]) {
				++curr[0];
				++curr[1];
				++curr[2];
			}
			sb.append("#").append(t).append(" ").append(a[e][0] - curr[0] + Math.abs(curr[1] - a[e][1]) + curr[2]).append("\n");
		}

		// output
		System.out.print(sb.toString());
	}
}