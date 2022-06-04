package Q1220_Magnetic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int TC = 1; TC <= 10; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[N + 1][N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 자석 이동시키기
			// 테이블의 위에 N극이 아래에 S극이 있으므로
			// 1인 N극은 아래로 내려가길 원하고
			// 2인 S극은 위로 올라가길 원한다.
			// 스왑을 통해 이동시키자.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (table[i][j] == 0) // 해당 좌표에 자석이 없다면 넘기기
						continue;

					if (table[i][j] == 1 && table[i + 1][j] == 0) { // 해당 좌표에 있는 자석이 N극이며 아랫칸에 자석이 없다면 서로 스왑
						int temp = table[i][j];
						table[i][j] = table[i + 1][j];
						table[i + 1][j] = temp;
						continue;
					}
					if (i - 1 >= 0 && table[i][j] == 2 && table[i - 1][j] == 0) { // 해당 좌표에 있는 자석이 S극이며 윗칸에 자석이 없다면 서로
																					// 스왑
						int temp = table[i][j];
						table[i][j] = table[i - 1][j];
						table[i - 1][j] = temp;
						continue;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (table[i][j] == 0) // 해당 좌표에 자석이 없다면 넘기기
						continue;

					if (table[i][j] == 1 && table[i + 1][j] == 0) { // 해당 좌표에 있는 자석이 N극이며 아랫칸에 자석이 없다면 서로 스왑
						int temp = table[i][j];
						table[i][j] = table[i + 1][j];
						table[i + 1][j] = temp;
						continue;
					}
					if (i - 1 >= 0 && table[i][j] == 2 && table[i - 1][j] == 0) { // 해당 좌표에 있는 자석이 S극이며 윗칸에 자석이 없다면 서로
																					// 스왑
						int temp = table[i][j];
						table[i][j] = table[i - 1][j];
						table[i - 1][j] = temp;
						continue;
					}
				}
			}

			// 스왑 종료
			// 서로 마주보고 있는 N극과 S극있다면 카운트
			// N극 기준 반복문 실행
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (table[i][j] == 1 && table[i + 1][j] == 2) // N극이면서 바로 아래에 S극이 존재한다며 서로 교착하고 있는 상황
						cnt++;
				}
			}

			System.out.printf("#%d %d\n", TC, cnt);
		}
	}
}
