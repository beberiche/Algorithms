package Q1311_카드게임;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] cnt = new int[10];
		int max = 0;
		char[][] arr = new char[5][2];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.next().charAt(0);
			}
			cnt[arr[i][1] - '0']++;
			max = Math.max(max, arr[i][1] - '0');
		}

		boolean straight = false;
		boolean flush = false;
		boolean fullhouse = false;
		boolean fourCard = false;
		boolean threeCard = false;
		boolean twoFairX2 = false;
		boolean twoFair = false;

		// 색 정렬
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		// 색이 동일한지 확인
		int colorCnt = 0;
		for (int i = 1; i < 5; i++) {
			if (arr[i][0] == arr[i - 1][0]) {
				colorCnt++;
			}
		}
		if (colorCnt >= 4) {
			flush = true;
		}

		// 숫자 정렬
		Arrays.sort(arr, (o1, o2) -> (o1[1] - '0') - (o2[1] - '0'));

		// 숫자가 연속적인지 확인
		if (arr[0][1] - '0' == arr[1][1] - '0' - 1 && arr[1][1] - '0' == arr[2][1] - '0' - 1
				&& arr[2][1] - '0' == arr[3][1] - '0' - 1
				&& arr[3][1] - '0' == arr[4][1] - '0' - 1) {
			straight = true;
		}

		// 숫자가 동일한지 확인
		int numCnt = 0;
		for (int i = 1; i < 5; i++) {
			if (arr[i][1] == arr[i - 1][1]) {
				numCnt++;
			}
		}

		if (numCnt == 3) {
			if ((arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] && arr[2][1] == arr[3][1])
					|| (arr[1][1] == arr[2][1] && arr[2][1] == arr[3][1]
							&& arr[3][1] == arr[4][1])) {
				fourCard = true;
			} else {
				fullhouse = true;
			}
		} else if (numCnt == 2) {
			if ((arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1])
					|| (arr[1][1] == arr[2][1] && arr[2][1] == arr[3][1])
					|| (arr[2][1] == arr[3][1] && arr[3][1] == arr[4][1])) {
				threeCard = true;
			} else {
				twoFairX2 = true;
			}
		} else if (numCnt == 1) {
			twoFair = true;
		}

		// 1
		if (straight && flush) {
			System.out.println(900 + max);
		}
		// 2
		else if (fourCard) {
			System.out.println(800 + (arr[2][1] - '0'));
		}
		// 3
		else if (fullhouse) {
			int threeNum = 0;
			int twoNum = 0;
			for (int i = 1; i < cnt.length; i++) {
				if (cnt[i] == 3) {
					threeNum = i;
				} else if (cnt[i] == 2) {
					twoNum = i;
				}
			}
			System.out.println(threeNum * 10 + twoNum + 700);
		}
		// 4
		else if (flush) {
			System.out.println(600 + max);
		}
		// 5
		else if (straight) {
			System.out.println(500 + max);
		}
		// 6
		else if (threeCard) {
			int threeNum = 0;
			for (int i = 1; i < cnt.length; i++) {
				if (cnt[i] == 3) {
					threeNum = i;
					break;
				}
			}
			System.out.println(400 + threeNum);
		}
		// 7
		else if (twoFairX2) {
			int maxTwoNum = 0;
			int minTwoNum = 9;
			for (int i = 1; i < cnt.length; i++) {
				if (cnt[i] == 2) {
					maxTwoNum = Math.max(maxTwoNum, i);
					minTwoNum = Math.min(minTwoNum, i);
				}
			}
			System.out.println(maxTwoNum * 10 + minTwoNum + 300);
		}
		// 8
		else if (twoFair) {
			int num = 0;
			for (int i = 1; i < cnt.length; i++) {
				if (cnt[i] == 2) {
					num = i;
					break;
				}
			}
			System.out.println(200 + num);
		}
		// 9
		else {
			System.out.println(100 + max);
		}
	}
}
