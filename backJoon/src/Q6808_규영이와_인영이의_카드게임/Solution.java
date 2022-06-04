package Q6808_규영이와_인영이의_카드게임;

import java.util.Scanner;

public class Solution {
	static int[] gyCards; // 규영이 카드
	static int[] iyCards; // 인영이 카드
	static int[] gyCardsSel; // 규영이 카드 셔플용
	static boolean visited[]; // 방문체크용
	static int gyWin; // 규영이가 이긴 횟수
	static int iyWin; // 인영이가 이긴 횟수 = 규영이가 진 횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean temp[];
		int T = sc.nextInt();
		for (int TC = 1; TC <= T; TC++) {
			// 카드 배분 확인용
			temp = new boolean[19];
			gyCards = new int[10];
			iyCards = new int[10];
			for (int i = 1; i <= 9; i++) {
				int n = sc.nextInt();
				gyCards[i] = n;
				temp[n] = true;
			}

			// temp 배열이 false 라면
			// 모두 인영이 카드
			int idx = 1;
			for (int i = 1; i <= 18; i++) {
				if (!temp[i]) {
					iyCards[idx] = i;
					idx++;
				}
			}

			gyWin = 0;
			iyWin = 0;

			visited = new boolean[10];
			gyCardsSel = new int[10];
			perm(1);
			System.out.println("#" + TC + " " + gyWin + " " + iyWin);
		}
	}

	public static void perm(int idx) {
		if (idx == 10) {
			winner();
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				gyCardsSel[idx] = gyCards[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
			}
		}
	}

	public static void winner() {
		int gyTotal = 0;
		int iyTotal = 0;
		for (int i = 1; i <= 9; i++) {
			if (gyCardsSel[i] > iyCards[i]) {
				gyTotal += gyCardsSel[i] + iyCards[i];
			} else {
				iyTotal += gyCardsSel[i] + iyCards[i];
			}
		}

		// 규영이가 이긴경우
		if (gyTotal > iyTotal) {
			gyWin++;
			// 규영이가 지는 경우
		} else if (gyTotal < iyTotal) {
			iyWin++;
		}

	}
}
