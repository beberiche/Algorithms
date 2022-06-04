package Q1204_조커;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] cards = new int[N];
		int jokerCnt = 0;
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
			if (cards[i] == 0)
				jokerCnt++;
		}

		Arrays.sort(cards);

		int ans = 0;
		// 조커 갯수가 N만큼 있는 경우는
		// 답은 조커 갯수
		if (jokerCnt == N) {
			ans = jokerCnt;
		} else {
			for (int i = jokerCnt; i < N; i++) {
				int coin = jokerCnt;
				int cnt = 1;
				for (int j = i; j < N - 1; j++) {
					int gap = cards[j + 1] - cards[j];
					// 연속성이 끊기는 조건
					if (cards[j + 1] - cards[j] - 1 > coin) {
						break;
						// 1인 경우에는 그냥 카운트
					} else if (cards[j + 1] - cards[j] == 1) {
						cnt++;
						// 조커로 해결할 수 있는 경우
					} else if (cards[j + 1] - cards[j] - 1 <= coin && cards[j + 1] != cards[j]) {
						cnt += cards[j + 1] - cards[j];
						coin -= cards[j + 1] - cards[j] - 1;
					}
				}

				if (coin > 0) {
					cnt += coin;
				}
				// 스트레이트는 최소 2개부터이므로
				// 카운트가 하나도 되지 않았다면 2개일 것이다.
				if (cnt == 1) {
					cnt = 2;
				}
				ans = Math.max(cnt, ans);
			}
		}
		System.out.println(ans);

	}
}
