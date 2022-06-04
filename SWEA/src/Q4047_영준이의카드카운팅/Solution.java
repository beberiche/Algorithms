package Q4047_영준이의카드카운팅;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./data/input4047.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int TC = 1; TC <= T; TC++) {
			String str = sc.next();

			// 카드 갯수 미리 설정
			int S = 13;
			int C = 13;
			int D = 13;
			int H = 13;

			// 영준이가 가지고 있는 카드는 정해진 게 아닌다.
			// 3단어씩 카드가 나오니 넣어야 할 배열의 크기는 문자길이/3;
			String[] cards = new String[str.length() / 3];
			int idx = 0;
			for (int i = 0; i < str.length(); i += 3) {
				// substring 활용
				cards[idx] = str.substring(i, 3 + i);
				idx++;
			}

			// ERROR 확인
			int ERROR = 0;
			for (int i = 0; i < cards.length; i++) {
				for (int j = i + 1; j < cards.length; j++) {
					if (cards[i].equals(cards[j])) {
						ERROR = -1;
						break;
					}
				}
			}

			// 필요한 갯수 찾기
			for (int i = 0; i < cards.length; i++) {
				switch (cards[i].charAt(0)) {
				case 'S':
					S--;
					break;
				case 'C':
					C--;
					break;
				case 'D':
					D--;
					break;
				case 'H':
					H--;
					break;
				}
			}

			if (ERROR == -1) {
				System.out.printf("#%d %s\n", TC, "ERROR");
			} else {
				System.out.printf("#%d %d %d %d %d\n", TC, S, D, H, C);
			}
		}

	}
}
