package 조합;

import java.util.Arrays;
import java.util.Scanner;

public class 조합 {
	static int N, R;
	static int[] data;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 6;
		R = 3;
		data = new int[] { 1, 2, 3, 4, 5, 6 };
		sel = new int[R];

		print("반복을 이용한 조합 - 무조건 3개 뽑기");
		comb1();

		print("반복 + 재귀를 이용한 조합 - 무조건 3개 뽑기");
		comb2(0, 0);

		print("재귀를 이용한 조합");
		comb3(0, 0);

		sc.close();
	}

	private static void print(String msg) {
		System.out.println("--------------------------------");
		System.out.println(msg);
		System.out.println("--------------------------------");
	}

	// "반복을 이용한 조합 - 무조건 3개 뽑기"
	private static void comb1() {
//		for (int i = 0; i < N - 2; i++) {
//			for (int j = i + 1; j < N - 1; j++) {
//				for (int k = j + 1; k < N; k++) {
//					System.out.println(data[i] + " " + data[j] + " " + data[k]);
//				}
//			}
//		}

		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					System.out.println(data[i] + " " + data[j] + " " + data[k]);
				}
			}
		}
	}

	// "반복 + 재귀를 이용한 조합 - 무조건 3개 뽑기"
	private static void comb2(int cnt, int st) {
		if (cnt == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = st; i < N; i++) {
			sel[cnt] = data[i];
			comb2(cnt + 1, i + 1);
		}
	}

	// "재귀를 이용한 조합"
	private static void comb3(int cnt, int idx) {
		if (cnt == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}

		if (idx == N) {
			return;
		}

		sel[cnt] = data[idx];
		comb3(cnt + 1, idx + 1);
		comb3(cnt, idx + 1);
	}
}