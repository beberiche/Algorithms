package Q2005_파스칼의_삼각형;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input2005.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int TC = 0;
		while (++TC <= T) {
			int N = sc.nextInt();

			int[][] triangle = new int[N][N];

			// 배열의 [r][0] 은 모두 1이다.
			for (int r = 0; r < N; r++) {
				triangle[r][0] = 1;
			}

			// 설정 시작
			if (N > 1) {
				for (int i = 1; i < N; i++) {
					for (int j = 1; j < i + 1; j++) {
						if (i - 1 < 0 && j - 1 < 0) { // 인덱스 에러 처리
							continue;
						}
						// 인덱스 에러가 걸리지 않는 영역
						// 해당 좌표의 값은 바로 위의 값과 그 옆의 값을 합친값
						triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
					}
				}
			}

			// 이후 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(TC).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (triangle[i][j] == 0) { // 배열은 초기에 0이 설정되어 있으므로 0이 아닌 것들만 골라주자.
						continue;
					}
					sb.append(triangle[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}
	}
}
