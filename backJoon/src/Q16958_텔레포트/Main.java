package Q16958_텔레포트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int T = Integer.parseInt(stk.nextToken());

		int[][] a = new int[N][];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			a[i] = new int[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())};
		}

		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j) {
					int d = Math.abs(a[i][1] - a[j][1]) + Math.abs(a[i][2] - a[j][2]);
					if (a[i][0] == 1 && a[j][0] == 1) d = Math.min(d, T);
					dist[i][j] = d;
				}
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(stk.nextToken())-1;
			int n2 = Integer.parseInt(stk.nextToken())-1;
			sb.append(dist[n1][n2]).append("\n");
		}

		System.out.print(sb.toString());
	}
}
