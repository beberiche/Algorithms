package Q6190_정곤이의단조증가하는수;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input6190.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			int N = sc.nextInt();

			// 입력
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			int max = 0; // max 값 구하기
			boolean cnt = false; // 단조 최댓값이 하나도 없는 경우 확인
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					char[] chArr = String.valueOf(arr[i] * arr[j]).toCharArray();

					int len = chArr.length;
					boolean flag = true; // 해당 곱이 단조 인지 확인
					for (int k = 0; k < len - 1; k++) {
						if (((int) chArr[k]) > ((int) chArr[k + 1])) {
							flag = false;
							break;
						}

					}

					if (flag) {
						max = Math.max(max, arr[i] * arr[j]);
						cnt = true;
					}
				}

			}

			System.out.printf("#%d %d\n", TC, cnt ? max : -1);
		}
	}
}
