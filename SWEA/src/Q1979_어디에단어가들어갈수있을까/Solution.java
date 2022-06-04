package Q1979_어디에단어가들어갈수있을까;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	static int N;
	static int len;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input1979.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int ans = 0;
		for (int TC = 1; TC <= T; TC++) {
			N = sc.nextInt();
			len = sc.nextInt();

			int[][] map = new int[N][N]; // 가로형
			int[][] map2 = new int[N][N]; // 세로형

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = map2[j][i] = sc.nextInt();
				}
			}

			// 가로 세로값 확인후 더하기
			System.out.printf("#%d %d\n", TC, solve(map) + solve(map2));
		}
	}

	public static int solve(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				// 1인 경우
				if (j + len - 1 < N) {
					boolean flag = true;
					for (int k = 0; k < len; k++) {
						if (map[i][j + k] != 1) {
							flag = false;
							break;
						}
					}

					// 1이 len개인 경우에서
					// 혹시 len+1개는 아닌지 확인해보자
					// ex) 글자길이 3인 곳을 찾고 있는데
					// 만약 11110 인 경우
					// 좌표(0,1)에서 1을 3개만 읽게 되어 카운트 될것이다.
					// 좌표에서 len개를 읽었다면,
					// 처음 좌표의 -1 좌표와 마지막 인덱스 +1의 좌표도 다시금 확인해보자.
					if (flag) {
						if (j - 1 >= 0 && map[i][j - 1] == 1)
							continue;
						if (j + len < N && map[i][j + len] == 1) {
							continue;
						}
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
