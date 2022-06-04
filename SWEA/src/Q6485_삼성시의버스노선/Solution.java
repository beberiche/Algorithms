package Q6485_삼성시의버스노선;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input6485.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();
			// A~B까지 거리이므로
			// 케이스가 몇개이든
			// j의 갯수는 항상 2개일 것이다.
			int[][] routes = new int[N][2];

			// 이차원 배열에 루트 넣어두기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					routes[i][j] = sc.nextInt();
				}
			}

			int P = sc.nextInt(); // 정류장 갯수

			// 반복문 및 출력
			StringBuilder sb = new StringBuilder();
			// P만큼 반복문을 돈다.
			sb.append("#").append(TC).append(" ");
			for (int i = 0; i < P; i++) {
				int cnt = 0;
				int n = sc.nextInt();
				// 노선 만큼의 반복문을 돌면서 해당 노선에 포함되는 곳인지
				// 카운트를 해준다.
				for (int j = 0; j < N; j++) {
					int st = routes[j][0];
					int ed = routes[j][1];

					if (st <= n && n <= ed) {
						cnt++;
					}
				}
				// 누적된 카운트를 출력
				sb.append(cnt).append(" ");
			}
			System.out.println(sb.toString().trim());
		}
	}
}
