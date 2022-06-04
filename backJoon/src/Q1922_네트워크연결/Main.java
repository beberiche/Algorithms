package Q1922_네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] network;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정점의 수
		int M = Integer.parseInt(br.readLine()); // 간선의 수

		network = new int[M + 1][3];

		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			network[i][0] = Integer.parseInt(st.nextToken()); // 시작점
			network[i][1] = Integer.parseInt(st.nextToken()); // 끝점
			network[i][2] = Integer.parseInt(st.nextToken()); // 가중치
		}

		Arrays.sort(network, (o1, o2) -> o1[2] - o2[2]);

		p = new int[N + 1];
		int ans = 0;
		for (int i = 1; i <= N; i++)
			p[i] = i;

		for (int i = 1; i <= M; i++) {
			int px = findSet(network[i][0]);
			int py = findSet(network[i][1]);
			if (px == py)
				continue;
			union(px, py);
			ans += network[i][2];
		}

		System.out.println(ans);

	}

	private static void union(int n1, int n2) {
		p[n2] = n1;
	}

	private static int findSet(int n) {
		if (p[n] == n)
			return n;
		return p[n] = findSet(p[n]);
	}
}
