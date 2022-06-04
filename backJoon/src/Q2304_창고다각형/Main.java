package Q2304_창고다각형;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 2차원 배열로 만들기 [좌표값, 높이값];
		int[][] w = new int[N][2];
		for (int i = 0; i < N; i++) {
			w[i][0] = sc.nextInt();
			w[i][1] = sc.nextInt();
		}

		// 좌표값 기준 sorting
		Arrays.sort(w, (o1, o2) -> o1[0] - o2[0]);

		// 기준값 찾기 (최대 높이값 및 최대 높이의 좌표)
		int maxH = 0;
		int midIdx = 0;
		for (int i = 0; i < N; i++) {
			if (maxH <= w[i][1]) {
				maxH = w[i][1];
				midIdx = i;
			}
		}

		// 1.제일 처음 부터 최대 높이 전까지의 면적 값
		// 2.최대 높이의 값
		// 3.최대 높이 후 부터 끝까지의 면적 값
		// 1.+2.+3. = 창고의 면적

		// 좌측 면적 찾기
		int ans = w[midIdx][1]; // 최대높이 부터 넣고 시작
		for (int i = 0; i < midIdx; i++) {
			for (int j = i + 1; i <= midIdx; j++) {
				if (w[i][1] <= w[j][1]) {
					ans += (w[j][0] - w[i][0]) * w[i][1];
					i = j;
					if (w[i][0] == w[midIdx][0]) { // i가 midIdx에 도달할 경우 반복문을 빠져나오기
						break;
					}
				}
			}
		}

		// 우측 면적 찾기
		// 좌측과 반대로
		for (int i = N - 1; i > midIdx; i--) {
			for (int j = i - 1; j >= midIdx; j--) {
				if (w[i][1] <= w[j][1]) {
					ans += (w[i][0] - w[j][0]) * w[i][1];
					i = j;
					if (w[i][0] == w[midIdx][0]) {
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
